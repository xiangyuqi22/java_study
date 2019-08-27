// import Home from '../components/Home'

// const Home = () => Promise.resolve({ "../components/Home" })
// const Home = () => import("../components/Home");
const Home = resolve => require(['../components/Home'],resolve);
const Menu = resolve => require(['../components/Menu'],resolve);
const Admin = resolve => require(['../components/Admin'],resolve);
const About = resolve => require(['../components/about/About'],resolve);
const Login = resolve => require(['../components/Login'],resolve);
const Register = resolve => require(['../components/Register'],resolve);
const History = resolve => require(['../components/History'],resolve);


//二级路由
const Contact = resolve => require(['../components/about/Contact'],resolve);
const HistoryOrder = resolve => require(['../components/about/HistoryOrder'],resolve);
const Delivery = resolve => require(['../components/about/Delivery'],resolve);
const OrderingGuide = resolve => require(['../components/about/OrderingGuide'],resolve);

//三级路由
const PersionName = resolve => require(['../components/about/contact/PersionName'],resolve);
const Phone = resolve => require(['../components/about/contact/Phone'],resolve);


//name 给组件取名
// :to="{name:'homeLink'}"

const contactRoutes = [
  {path:'/about/contact/phone',name:"phoneLink",component:Phone},
  {path:'/about/contact/PersionName',name:"persionNameLink",component:PersionName},
]

const aboutRoutes = [
  { path: '/about/contact', name:"contactLink",redirect: '/about/contact/PersionName' , component:Contact ,children:contactRoutes},
  { path: '/historyOrder', name:"historyOrderLink", component: HistoryOrder },
  { path: '/delivery', name:"deliveryLink", component: Delivery },
  { path: '/orderingGuide',  name:"orderingGuideLink",component: OrderingGuide,beforeEnter: (to, from, next) => {
        //独享守卫
        if(confirm("确定要进入页面吗?") ){
          next();
        }
      }},
];

export const routes = [
  { path: '/',name:"homeLink", components: {
    default:Home,
    "contactView":Contact,
    "deliveryView":HistoryOrder,
    "historyView":Delivery,
    "orderingView":OrderingGuide,
  } },
  { path: '/menu',name:"menuLink", component: Menu },
  { path: '/admin/:username',name:"adminLink", component: Admin , props: true},
  { path: '/login', name:"loginLink",component: Login },
  { path: '/register',name:"registerLink", component: Register },
  { path: '/history', component: History },
  { path: '/about', component: About , redirect:'/historyOrder',children:aboutRoutes , beforeEnter: (to, from, next) => {
        console.log("独享守卫");
        next();
      }},//  注意:使用children
  { path: '*', component: Home },
  // {path:"*",redirect:"/"}
]

//
// export const router = new VueRouter({
//   routes, // (缩写) 相当于 routes: routes,
//   mode : "history"
// })
//

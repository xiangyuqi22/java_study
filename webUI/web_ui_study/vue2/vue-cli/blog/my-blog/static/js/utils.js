// let _utils =  function (){
//
//
//    this.parseTime = function(time){
//     return new Date(parseInt(time)).toLocaleString().replace(/:\d{1,2}$/,' ');
//   }
//
//
// }

var _utils = {
     parseTime : function(time){
        return new Date(parseInt(time)).toLocaleString().replace(/:\d{1,2}$/,' ');
     }
}

export default _utils;

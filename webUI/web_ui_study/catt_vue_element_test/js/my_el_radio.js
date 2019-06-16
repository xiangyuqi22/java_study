Vue.component('catt-radio',{
			template : `
				<el-radio-group v-model="radio1" >
				      <el-radio-button v-for="(s,index) in sex" 
				      v-bind:label="s"
				      v-bind:key="index"
				      checked='true'>
				      </el-radio-button>
				</el-radio-group>
			`,	
			data : function(){
				return {
					radio1 : this.radio
				}
			},
			props : {
				sex : {
					type : Array
				},
				radio : {
					type : String
				}
			},
})

		var gender = ['男','女'];
		var users = [
						{'id':1,'name':'李白','gender':'男','username':'libai','dept':'市场部','date':'2019-01-01'},
						{'id':2,'name':'杜甫','gender':'男','username':'dufu','dept':'市场部','date':'2019-01-01'},
						{'id':3,'name':'白居易','gender':'男','username':'baijuyi','dept':'市场部','date':'2019-01-01'},
						{'id':4,'name':'苏东坡','gender':'男','username':'sudongpo','dept':'市场部','date':'2019-01-01'},
					];
		
		var vm = new Vue({
			el: "#app",
			data: 
				function(){
					return {
							sex: gender,
							depts : ['市场部','财务部','研发部'],
							form : {
								name : "",
								gender : gender[0],
								dept : "",
								date : []
							},
							tableData : users,
							currentPage : 1,
					};
			},
			methods : {
				handleSizeChange : function(val){
					this.$message(`每页 ${val} 条`);
				},
			   	handleCurrentChange(val) {
			        this.$message(`当前页: ${val}`);
			    },
			    search : function(){
			    	this.$message("查看数据--已经实现了姓名查询:" + this.form.name);
			    	var name = this.form.name;
			    	if(name){
			    		var newUsers = [];
				    	console.log(name);
				    	for (var i=0; i < users.length ; i++) {
				    		if(users[i].name.indexOf(name) != -1){
				    			newUsers.push(users[i]);
				    		}
				    	}
				    	this.tableData = newUsers;
			    	}else{
			    		this.tableData = users;
			    	}
			    	
			    },
			    add : function(){
			    	this.$message("新增数据:" + this.form.name);
			    },
			    deleteData : function(){
			    	this.$message("删除数据:" + this.form.name);
			    },
			    edit : function(){
			    	this.$message("修改数据 :" + this.form.name);
			    },
			    see : function(){
			    	cthis.$message("查看详情:" + this.form.name);
			    }
			},
			computed : {
				total : function(){
					return this.tableData.length;
				}
			}
		})
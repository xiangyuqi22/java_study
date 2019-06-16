/**
 * vue显示
 */
 var my_name = "vue";

/**
 * @description 在这里显示描述内容
 */
function showMessage(){
	console.log("显示信息");
}

/**
 * @description  通过损耗CPU达到线程休眠时间
 * @param {Object} 线程休眠时间
 */
function sleep(n) {
	var start = new Date().getTime();
	while(true)  if(new Date().getTime()-start > n) break;
}

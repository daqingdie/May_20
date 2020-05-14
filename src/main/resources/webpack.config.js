const path = require('path');  //node.js中的函数

module.exports={
    entry: './static/js/cart.js',
    output:{
        path:path.resolve(__dirname,'static/js'), //获取当前的绝对路径
        filename:'myMain.js',

    }
}
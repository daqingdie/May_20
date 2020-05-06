const path = require('path');

module.exports={
    entry: './static/js/cart.js',
    output:{
        path:path.resolve(__dirname,'static/js'),
        filename:'myMain.js',

    }
}
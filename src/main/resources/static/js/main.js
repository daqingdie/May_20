/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 1);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return sum; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return flag; });
var app5 = new Vue({
    el: '#app5',
    data: {
        message: '测试vue'
    }
});

const sum=function(){
    console.log("测试打印内容");
};

//模块化导出格式为:export{属性名/方法名/类名...}


//也可以用export var 属性名/方法名=定义,的格式导出
var flag = '测试内容';

//使用export default导出可以让导入方自定义名称,但只能导出一个
var message = "默认导出内容";
/* harmony default export */ __webpack_exports__["a"] = (message);

/***/ }),
/* 1 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__MyVue_js__ = __webpack_require__(0);
const app = new Vue({
    el: "#app",
    data:{
        message:'购物车演示',
        books:[{id:1,name:"JAVA开发",btime:"2019.03",price:23.99,num:1},
                {id:2,name:"C++开发",btime:"2019.04",price:22.99,num:1},
                {id:3,name:"Python开发",btime:"2019.05",price:28.99,num:1},
                {id:4,name:"PHP开发",btime:"2019.06",price:24.99,num:1},
        ],
        nums: [1, 2, 3, 4, 5,],
        isBooks:false,
    },
    computed:{
        sumP:function() {
            return this.books.reduce((pre, b) => pre + b.price*b.num,1);
        },
        sum:function () {
            return 1;
        }
    },
    methods: {
        arm(id) {
            for(let i=0;i<this.books.length;i++){
                if(this.books[i].id==id){
                    this.books.splice(i, 1);
                    if(this.books.length==0)
                        this.isBooks=true;
                }
            }
            //window.alert("移除成功");
        },
        change(num,id) {
            if(num<=1){
                window.alert("数量不可以小于1");
            }else {
                for(let b of this.books)
                    if(b.id==id)
                        b.num--;
            }

        }
    },
    //filters过滤器格式，方法名(过滤的参数){},调用时在属性后面加“|过滤器”，会自动将该属性作为参数传进来
    filters:{
        showPrice(price) {
            return "￥"+price.toFixed(2)  //toFixed可以限制小数点后位数
        },
    },

})

//模块化导入的格式为 import {方法名/属性名} from "路径(如./MyVue.js)";


//导入默认,可自定义名称


//导入全部数据,格式为import * as 名字 from "路径",调用时采用名字.属性调用


const mysum=function () {
    console.log(__WEBPACK_IMPORTED_MODULE_0__MyVue_js__["b" /* flag */]);
    console.log(__WEBPACK_IMPORTED_MODULE_0__MyVue_js__["a" /* default */]);
    Object(__WEBPACK_IMPORTED_MODULE_0__MyVue_js__["c" /* sum */])();
    console.log(__WEBPACK_IMPORTED_MODULE_0__MyVue_js__["b" /* flag */]);
}()

/***/ })
/******/ ]);
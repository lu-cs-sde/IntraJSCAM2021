(window.webpackJsonp=window.webpackJsonp||[]).push([[338,15,360],{1806:function(e,t,n){"use strict";n.r(t),n.d(t,"ProjectAdminPageExtension",(function(){return c}));var r=n(2),o=n(325),a=n(416),s=n(486),i=n(564);function c(e){const{component:t,params:{extensionKey:n,pluginKey:o}}=e,a=t.configuration&&(t.configuration.extensions||[]).find(e=>e.key==="".concat(o,"/").concat(n));return a?r.createElement(i.a,{extension:a,options:{component:t}}):r.createElement(s.default,{withContainer:!1})}const l={onFail:a.a};t.default=Object(o.b)(null,l)(c)},461:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return c}));var r=n(2),o=n(517),a=n.n(o),s=n(350),i=n(542);function c({children:e}){return r.createElement("div",{className:"global-container"},r.createElement("div",{className:"page-wrapper",id:"container"},r.createElement(a.a,{className:"navbar-global",height:s.rawSizes.globalNavHeightRaw}),e),r.createElement(i.a,null))}},486:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return c}));var r=n(2),o=n(335),a=n(318),s=n(31),i=n(461);function c({withContainer:e=!0}){const t=e?i.default:r.Fragment;return r.createElement(t,null,r.createElement(o.a,{defaultTitle:Object(s.translate)("404_not_found"),defer:!1}),r.createElement("div",{className:"page-wrapper-simple",id:"bd"},r.createElement("div",{className:"page-simple",id:"nonav"},r.createElement("h2",{className:"big-spacer-bottom"},Object(s.translate)("page_not_found")),r.createElement("p",{className:"spacer-bottom"},Object(s.translate)("address_mistyped_or_page_moved")),r.createElement("p",null,r.createElement(a.c,{to:"/"},Object(s.translate)("go_back_to_homepage"))))))}},530:function(e,t,n){"use strict";n.d(t,"b",(function(){return s})),n.d(t,"a",(function(){return i}));var r=n(338),o=n(17);let a=!1;function s(e,t="body"){return new Promise(n=>{const o=document.createElement("script");o.src="".concat(Object(r.getBaseUrl)()).concat(e),o.onload=n,document.getElementsByTagName(t)[0].appendChild(o)})}async function i(e){const t=Object(o.a)(e);if(t)return Promise.resolve(t);if(!a){a=!0,(0,(await Promise.all([n.e(0),n.e(1),n.e(2),n.e(273),n.e(317)]).then(n.bind(null,687))).default)()}await s("/static/".concat(e,".js"));const r=Object(o.a)(e);return r||Promise.reject()}},564:function(e,t,n){"use strict";var r=n(2),o=n(335),a=n(316),s=n(325),i=n(31),c=n(367),l=n(530),u=n(18),p=n(6),m=n(416),d=n(327),b=n(350),h=n(414);function f(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function O(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}class E extends r.PureComponent{constructor(){super(...arguments),this.state={},this.handleStart=e=>{const t=e(function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?f(Object(n),!0).forEach((function(t){O(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):f(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({store:Object(h.default)(),el:this.container,currentUser:this.props.currentUser,intl:this.props.intl,location:this.props.location,router:this.props.router,theme:b,baseUrl:Object(p.getBaseUrl)(),l10nBundle:Object(u.a)()},this.props.options));t&&(r.isValidElement(t)?this.setState({extensionElement:t}):"function"==typeof t&&(this.stop=t))},this.handleFailure=()=>{this.props.onFail(Object(i.translate)("page_extension_failed"))}}componentDidMount(){this.startExtension()}componentDidUpdate(e){e.extension!==this.props.extension?(this.stopExtension(),this.startExtension()):e.location!==this.props.location&&this.startExtension()}componentWillUnmount(){this.stopExtension()}startExtension(){Object(l.a)(this.props.extension.key).then(this.handleStart,this.handleFailure)}stopExtension(){this.stop?(this.stop(),this.stop=void 0):this.setState({extensionElement:void 0})}render(){return r.createElement("div",null,r.createElement(o.a,{title:this.props.extension.name}),this.state.extensionElement?this.state.extensionElement:r.createElement("div",{ref:e=>this.container=e}))}}const j={onFail:m.a};t.a=Object(a.injectIntl)(Object(c.a)(Object(s.b)(e=>({currentUser:Object(d.getCurrentUser)(e)}),j)(E)))}}]);
//# sourceMappingURL=338.m.d54c87b2.chunk.js.map
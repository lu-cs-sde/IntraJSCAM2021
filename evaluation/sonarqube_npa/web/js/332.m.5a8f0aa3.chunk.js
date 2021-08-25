(window.webpackJsonp=window.webpackJsonp||[]).push([[332],{1862:function(e,t,n){"use strict";n.r(t);var r=n(2),a=n(318),i=n(385),l=n(482),o=n(348),c=n.n(o),s=n(31);class u extends r.PureComponent{constructor(){super(...arguments),this.handleChange=e=>{this.props.onCompare(e.value)}}render(){const{profile:e,profiles:t,withKey:n}=this.props,a=t.filter(t=>t.language===e.language&&t!==e).map(e=>({value:e.key,label:e.name}));return r.createElement("div",{className:"display-inline-block"},r.createElement("label",{className:"spacer-right"},Object(s.translate)("quality_profiles.compare_with")),r.createElement(c.a,{className:"input-large",clearable:!1,onChange:this.handleChange,options:a,placeholder:Object(s.translate)("select_verb"),value:n}))}}var p=n(509),f=n.n(p),h=n(448),m=n.n(h),d=n(450),y=n.n(d),g=n(321);function O(){return r.createElement("div",{className:"big-spacer-top"},Object(s.translate)("quality_profile.empty_comparison"))}var b=n(312),j=n(333),v=n(319),E=n.n(v),_=n(458);const q=Object(j.lazyLoadComponent)(()=>Promise.all([n.e(3),n.e(353)]).then(n.bind(null,1073)),"ActivationFormModal");class P extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={state:"closed"},this.handleButtonClick=()=>{this.setState({state:"opening"}),Object(_.c)({key:this.props.ruleKey}).then(({rule:e})=>{this.mounted&&this.setState({rule:e,state:"open"})},()=>{this.mounted&&this.setState({state:"closed"})})},this.handleCloseModal=()=>{this.setState({state:"closed"})}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}isOpen(e){return"open"===e.state}render(){const{profile:e}=this.props;return!e.isBuiltIn&&e.actions&&e.actions.edit?r.createElement(E.a,{loading:"opening"===this.state.state},r.createElement(b.Button,{disabled:"closed"!==this.state.state,onClick:this.handleButtonClick},this.props.children),this.isOpen(this.state)&&r.createElement(q,{modalHeader:Object(s.translate)("coding_rules.activate_in_quality_profile"),onClose:this.handleCloseModal,onDone:this.props.onDone,profiles:[e],rule:this.state.rule})):null}}class k extends r.PureComponent{renderRule(e,t){return r.createElement("div",null,r.createElement(y.a,{severity:t})," ",r.createElement(a.c,{to:Object(g.B)({rule_key:e.key,open:e.key})},e.name))}renderParameters(e){return e?r.createElement("ul",null,Object.keys(e).map(t=>r.createElement("li",{className:"spacer-top",key:t},r.createElement("code",null,t,": ",e[t])))):null}renderLeft(){return 0===this.props.inLeft.length?null:r.createElement(r.Fragment,null,r.createElement("tr",null,r.createElement("td",null,r.createElement("h6",null,Object(s.translateWithParameters)("quality_profiles.x_rules_only_in",this.props.inLeft.length)," ",this.props.left.name)),r.createElement("td",null," ")),this.props.inLeft.map(e=>r.createElement("tr",{className:"js-comparison-in-left",key:"left-".concat(e.key)},r.createElement("td",null,this.renderRule(e,e.severity)),r.createElement("td",null,this.props.rightProfile&&r.createElement(P,{key:e.key,onDone:this.props.refresh,profile:this.props.rightProfile,ruleKey:e.key},r.createElement(m.a,null))))))}renderRight(){return 0===this.props.inRight.length?null:r.createElement(r.Fragment,null,r.createElement("tr",null,r.createElement("td",null," "),r.createElement("td",null,r.createElement("h6",null,Object(s.translateWithParameters)("quality_profiles.x_rules_only_in",this.props.inRight.length)," ",this.props.right.name))),this.props.inRight.map(e=>r.createElement("tr",{className:"js-comparison-in-right",key:"right-".concat(e.key)},r.createElement("td",{className:"text-right"},r.createElement(P,{key:e.key,onDone:this.props.refresh,profile:this.props.leftProfile,ruleKey:e.key},r.createElement(f.a,null))),r.createElement("td",null,this.renderRule(e,e.severity)))))}renderModified(){return 0===this.props.modified.length?null:r.createElement(r.Fragment,null,r.createElement("tr",null,r.createElement("td",{className:"text-center",colSpan:2},r.createElement("h6",null,Object(s.translateWithParameters)("quality_profiles.x_rules_have_different_configuration",this.props.modified.length)))),r.createElement("tr",null,r.createElement("td",null,r.createElement("h6",null,this.props.left.name)),r.createElement("td",null,r.createElement("h6",null,this.props.right.name))),this.props.modified.map(e=>r.createElement("tr",{className:"js-comparison-modified",key:"modified-".concat(e.key)},r.createElement("td",null,this.renderRule(e,e.left.severity),this.renderParameters(e.left.params)),r.createElement("td",null,this.renderRule(e,e.right.severity),this.renderParameters(e.right.params)))))}render(){return this.props.inLeft.length||this.props.inRight.length||this.props.modified.length?r.createElement("table",{className:"data zebra quality-profile-comparison-table"},r.createElement("tbody",null,this.renderLeft(),this.renderRight(),this.renderModified())):r.createElement(O,null)}}class S extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1},this.loadResults=()=>{const{withKey:e}=this.props.location.query;return e?(this.setState({loading:!0}),Object(i.h)(this.props.profile.key,e).then(({left:e,right:t,inLeft:n,inRight:r,modified:a})=>{this.mounted&&this.setState({left:e,right:t,inLeft:n,inRight:r,modified:a,loading:!1})},()=>{this.mounted&&this.setState({loading:!1})})):(this.setState({left:void 0,loading:!1}),Promise.resolve())},this.handleCompare=e=>{const t=Object(l.c)(this.props.profile.name,this.props.profile.language,e);this.props.router.push(t)}}componentDidMount(){this.mounted=!0,this.loadResults()}componentDidUpdate(e){e.profile===this.props.profile&&e.location===this.props.location||this.loadResults()}componentWillUnmount(){this.mounted=!1}hasResults(e){return void 0!==e.left}render(){const{profile:e,profiles:t,location:n}=this.props,{withKey:a}=n.query;return r.createElement("div",{className:"boxed-group boxed-group-inner js-profile-comparison"},r.createElement("header",null,r.createElement(u,{onCompare:this.handleCompare,profile:e,profiles:t,withKey:a}),this.state.loading&&r.createElement("i",{className:"spinner spacer-left"})),this.hasResults(this.state)&&r.createElement("div",{className:"spacer-top"},r.createElement(k,{inLeft:this.state.inLeft,inRight:this.state.inRight,left:this.state.left,leftProfile:e,modified:this.state.modified,refresh:this.loadResults,right:this.state.right,rightProfile:t.find(e=>e.key===a)})))}}t.default=Object(a.g)(S)},362:function(e,t,n){var r=n(336),a=n(329),i=n(439),l=n(369);e.exports=function(e,t){return(l(e)?r:i)(e,a(t,3))}},385:function(e,t,n){"use strict";n.d(t,"A",(function(){return u})),n.d(t,"s",(function(){return p})),n.d(t,"j",(function(){return f})),n.d(t,"y",(function(){return h})),n.d(t,"r",(function(){return m})),n.d(t,"q",(function(){return d})),n.d(t,"C",(function(){return y})),n.d(t,"x",(function(){return g})),n.d(t,"i",(function(){return O})),n.d(t,"l",(function(){return b})),n.d(t,"g",(function(){return j})),n.d(t,"t",(function(){return v})),n.d(t,"u",(function(){return E})),n.d(t,"o",(function(){return _})),n.d(t,"n",(function(){return q})),n.d(t,"p",(function(){return P})),n.d(t,"h",(function(){return k})),n.d(t,"d",(function(){return S})),n.d(t,"m",(function(){return N})),n.d(t,"B",(function(){return w})),n.d(t,"z",(function(){return C})),n.d(t,"c",(function(){return R})),n.d(t,"w",(function(){return x})),n.d(t,"b",(function(){return z})),n.d(t,"v",(function(){return L})),n.d(t,"e",(function(){return J})),n.d(t,"f",(function(){return M})),n.d(t,"a",(function(){return D})),n.d(t,"k",(function(){return K}));var r=n(362),a=n.n(r),i=n(491),l=n(9),o=n(324);function c(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function s(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function u(e){return Object(l.getJSON)("/api/qualityprofiles/search",e).catch(o.a)}function p({compareToSonarWay:e,profile:{key:t}}){return Object(l.getJSON)("/api/qualityprofiles/show",{compareToSonarWay:e,key:t})}function f(e){return Object(l.postJSON)("/api/qualityprofiles/create",e).catch(o.a)}function h(e){return Object(l.postJSON)("/api/qualityprofiles/restore",e).catch(o.a)}function m(e){return Object(l.getJSON)("/api/qualityprofiles/projects",e).catch(o.a)}function d({language:e,name:t}){return Object(l.getJSON)("/api/qualityprofiles/inheritance",{language:e,qualityProfile:t}).catch(o.a)}function y({language:e,name:t}){return Object(l.post)("/api/qualityprofiles/set_default",{language:e,qualityProfile:t})}function g(e,t){return Object(l.post)("/api/qualityprofiles/rename",{key:e,name:t}).catch(o.a)}function O(e,t){return Object(l.postJSON)("/api/qualityprofiles/copy",{fromKey:e,toName:t}).catch(o.a)}function b({language:e,name:t}){return Object(l.post)("/api/qualityprofiles/delete",{language:e,qualityProfile:t}).catch(o.a)}function j({language:e,name:t},n){return Object(l.post)("/api/qualityprofiles/change_parent",{language:e,qualityProfile:t,parentQualityProfile:n?n.name:void 0}).catch(o.a)}function v({language:e,name:t}){const n=Object.entries({language:e,qualityProfile:t}).map(([e,t])=>"".concat(e,"=").concat(encodeURIComponent(t))).join("&");return"/api/qualityprofiles/backup?".concat(n)}function E({key:e},{language:t,name:n}){const r=Object.entries({exporterKey:e,language:t,qualityProfile:n}).map(([e,t])=>"".concat(e,"=").concat(encodeURIComponent(t))).join("&");return"/api/qualityprofiles/export?".concat(r)}function _(){return Object(l.getJSON)("/api/qualityprofiles/importers").then(e=>e.importers,o.a)}function q(){return Object(l.getJSON)("/api/qualityprofiles/exporters").then(e=>e.exporters)}function P(e,t,{language:n,name:r},a){return Object(l.getJSON)("/api/qualityprofiles/changelog",{since:e,to:t,language:n,qualityProfile:r,p:a})}function k(e,t){return Object(l.getJSON)("/api/qualityprofiles/compare",{leftKey:e,rightKey:t})}function S({language:e,name:t},n){return Object(l.post)("/api/qualityprofiles/add_project",{language:e,qualityProfile:t,project:n}).catch(o.a)}function N({language:e,name:t},n){return Object(l.post)("/api/qualityprofiles/remove_project",{language:e,qualityProfile:t,project:n}).catch(o.a)}function w(e){return Object(l.getJSON)("/api/qualityprofiles/search_users",e).catch(o.a)}function C(e){return Object(l.getJSON)("/api/qualityprofiles/search_groups",e).catch(o.a)}function R(e){return Object(l.post)("/api/qualityprofiles/add_user",e).catch(o.a)}function x(e){return Object(l.post)("/api/qualityprofiles/remove_user",e).catch(o.a)}function z(e){return Object(l.post)("/api/qualityprofiles/add_group",e).catch(o.a)}function L(e){return Object(l.post)("/api/qualityprofiles/remove_group",e).catch(o.a)}function J(e){return Object(l.postJSON)("/api/qualityprofiles/activate_rules",e)}function M(e){return Object(l.postJSON)("/api/qualityprofiles/deactivate_rules",e)}function D(e){const t=e.params&&a()(e.params,(e,t)=>"".concat(t,"=").concat(Object(i.csvEscape)(e))).join(";");return Object(l.post)("/api/qualityprofiles/activate_rule",function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?c(Object(n),!0).forEach((function(t){s(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):c(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}({},e,{params:t})).catch(o.a)}function K(e){return Object(l.post)("/api/qualityprofiles/deactivate_rule",e).catch(o.a)}},450:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)},a=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(e);a<r.length;a++)t.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(e,r[a])&&(n[r[a]]=e[r[a]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var i=n(2),l=n(315),o={blocker:function(e){return i.createElement(l.ThemedIcon,r({},e),(function(e){var t=e.theme;return i.createElement("path",{d:"M8 14c-3.311 0-6-2.689-6-6s2.689-6 6-6 6 2.689 6 6-2.689 6-6 6zM7 9h2V4H7v5zm0 3h2v-2H7v2z",style:{fill:t.colors.red,fillRule:"nonzero"}})}))},critical:function(e){return i.createElement(l.ThemedIcon,r({},e),(function(e){var t=e.theme;return i.createElement("path",{d:"M8 2c3.311 0 6 2.689 6 6s-2.689 6-6 6-6-2.689-6-6 2.689-6 6-6zm1 10V7.414l1.893 1.893c.13.124.282.216.457.261a1.006 1.006 0 0 0 1.176-.591 1.01 1.01 0 0 0 .01-.729 1.052 1.052 0 0 0-.229-.355c-1.212-1.212-2.394-2.456-3.638-3.636a1.073 1.073 0 0 0-.169-.123 1.05 1.05 0 0 0-.448-.133h-.104a1.053 1.053 0 0 0-.493.16 1.212 1.212 0 0 0-.162.132C6.08 5.505 4.836 6.687 3.656 7.932a.994.994 0 0 0-.051 1.275c.208.271.548.42.888.389.198-.019.378-.098.535-.218.041-.035.04-.034.079-.071L7 7.414V12h2z",style:{fill:t.colors.red,fillRule:"nonzero"}})}))},major:function(e){return i.createElement(l.ThemedIcon,r({},e),(function(e){var t=e.theme;return i.createElement("path",{d:"M8 2c3.311 0 6 2.689 6 6s-2.689 6-6 6-6-2.689-6-6 2.689-6 6-6zm.08 2.903c.071.008.14.019.208.039.138.042.26.114.37.205 1.244 1.146 2.426 2.357 3.639 3.536.1.103.181.218.234.352a1.01 1.01 0 0 1 .001.728 1.002 1.002 0 0 1-1.169.609 1.042 1.042 0 0 1-.46-.255L8 7.295l-2.903 2.822c-.039.036-.039.036-.08.07a1.002 1.002 0 0 1-1.604-.947c.032-.196.122-.37.253-.519C4.847 7.51 6.09 6.362 7.303 5.183c.052-.048.106-.093.167-.131a1.041 1.041 0 0 1 .61-.149z",style:{fill:t.colors.red}})}))},minor:function(e){return i.createElement(l.ThemedIcon,r({},e),(function(e){var t=e.theme;return i.createElement("path",{d:"M8 2c3.311 0 6 2.689 6 6s-2.689 6-6 6-6-2.689-6-6 2.689-6 6-6zm1 6.586V4H7v4.586L5.107 6.693a1.178 1.178 0 0 0-.165-.134 1.041 1.041 0 0 0-.662-.152 1 1 0 0 0-.587 1.7c1.212 1.212 2.394 2.456 3.638 3.636.094.08.195.146.311.191a1.008 1.008 0 0 0 1.065-.227c1.213-1.212 2.457-2.394 3.637-3.639a.994.994 0 0 0 .051-1.275 1.012 1.012 0 0 0-.888-.389 1.041 1.041 0 0 0-.535.218c-.04.034-.04.034-.079.071L9 8.586z",style:{fill:t.colors.lightGreen}})}))},info:function(e){return i.createElement(l.ThemedIcon,r({},e),(function(e){var t=e.theme;return i.createElement("path",{d:"M8 2c3.311 0 6 2.689 6 6s-2.689 6-6 6-6-2.689-6-6 2.689-6 6-6zm1 5H7v5h2V7zm0-3H7v2h2V4z",style:{fill:t.colors.blue}})}))}};t.default=function(e){var t=e.severity,n=a(e,["severity"]);if(!t)return null;var l=o[t.toLowerCase()];return l?i.createElement(l,r({},n)):null}},491:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.csvEscape=function(e){return'"'+e.replace(/"/g,'\\"')+'"'}},509:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)},a=this&&this.__rest||function(e,t){var n={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(n[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(e);a<r.length;a++)t.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(e,r[a])&&(n[r[a]]=e[r[a]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var i=n(2),l=n(315);t.default=function(e){var t=e.fill,n=void 0===t?"currentColor":t,o=a(e,["fill"]);return i.createElement(l.default,r({},o),i.createElement("path",{d:"M4.404 8.28l4.604 4.602a.382.382 0 0 0 .279.118c.108 0 .2-.04.279-.118l1.03-1.03a.382.382 0 0 0 .117-.278.382.382 0 0 0-.117-.28L7.3 8l3.295-3.294a.382.382 0 0 0 .117-.28.382.382 0 0 0-.117-.279l-1.03-1.03A.382.382 0 0 0 9.286 3a.382.382 0 0 0-.278.118L4.404 7.72A.382.382 0 0 0 4.287 8c0 .108.04.201.117.28z",style:{fill:n}}))}}}]);
//# sourceMappingURL=332.m.5a8f0aa3.chunk.js.map
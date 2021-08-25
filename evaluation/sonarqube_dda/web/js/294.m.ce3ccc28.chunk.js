(window.webpackJsonp=window.webpackJsonp||[]).push([[294],{1865:function(t,e,n){"use strict";n.r(e),n.d(e,"AdminContainer",(function(){return R}));var r=n(2),a=n(335),i=n(325),s=n(31),o=n(563),c=n(638),l=n(535),u=n(637),p=n(559),m=n(327),d=n(731),f=n(311),h=n(318),b=n(326),g=n.n(b),v=n(334),y=n.n(v),O=n(840),j=n.n(O),_=n(700),S=n.n(_),E=n(338),x=n(350),P=n(316),C=n(312),w=n(322),N=n(459),k=n(862);class A extends r.PureComponent{constructor(){super(...arguments),this.handleRevert=()=>{Object(c.a)().then(this.props.refreshPending,()=>{})}}render(){const{installing:t,updating:e,removing:n}=this.props.pending;return t.length||e.length||n.length?r.createElement(w.Alert,{className:"js-pending",display:"banner",variant:"info"},r.createElement("div",{className:"display-flex-center"},r.createElement("span",{className:"little-spacer-right"},r.createElement(N.a,{message:Object(s.translate)("marketplace.instance_needs_to_be_restarted_to")})),[{length:t.length,msg:"marketplace.install_x_plugins"},{length:e.length,msg:"marketplace.update_x_plugins"},{length:n.length,msg:"marketplace.uninstall_x_plugins"}].filter(({length:t})=>t>0).map(({length:t,msg:e},n)=>r.createElement("span",{key:e},n>0&&"; ",r.createElement(P.FormattedMessage,{defaultMessage:Object(s.translate)(e),id:e,values:{nb:r.createElement("strong",null,t)}}))),r.createElement(k.a,{className:"spacer-left",fetchSystemStatus:this.props.fetchSystemStatus,systemStatus:this.props.systemStatus}),r.createElement(C.Button,{className:"spacer-left js-cancel-all",onClick:this.handleRevert},Object(s.translate)("marketplace.revert")))):null}}var T=n(6);function D(){return r.createElement(w.Alert,{display:"banner",variant:"info"},r.createElement(P.FormattedMessage,{defaultMessage:Object(s.translate)("system.instance_restarting"),id:"system.instance_restarting",values:{instance:Object(T.getInstance)(),link:r.createElement(h.c,{to:{pathname:"/admin/background_tasks"}},Object(s.translate)("background_tasks.page"))}}))}class M extends r.PureComponent{constructor(){super(...arguments),this.renderExtension=({key:t,name:e})=>r.createElement("li",{key:t},r.createElement(h.c,{activeClassName:"active",to:"/admin/extension/".concat(t)},e))}isSomethingActive(t){const e=window.location.pathname;return t.some(t=>0===e.indexOf(Object(E.getBaseUrl)()+t))}isSecurityActive(){return this.isSomethingActive(["/admin/users","/admin/groups","/admin/permissions","/admin/permission_templates"])}isProjectsActive(){return this.isSomethingActive(["/admin/projects_management","/admin/background_tasks"])}isSystemActive(){return this.isSomethingActive(["/admin/system"])}isMarketplace(){return this.isSomethingActive(["/admin/marketplace"])}renderConfigurationTab(){const t=this.props.extensions.filter(t=>"license/support"!==t.key);return r.createElement(g.a,{overlay:r.createElement("ul",{className:"menu"},r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/settings"},Object(s.translate)("settings.page"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/settings/encryption"},Object(s.translate)("property.category.security.encryption"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/custom_metrics"},Object(s.translate)("custom_metrics.page"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/webhooks"},Object(s.translate)("webhooks.page"))),t.map(this.renderExtension)),tagName:"li"},({onToggleClick:t,open:e})=>r.createElement("a",{"aria-expanded":e,"aria-haspopup":"menu",role:"button",className:f("dropdown-toggle",{active:e||!this.isSecurityActive()&&!this.isProjectsActive()&&!this.isSystemActive()&&!this.isSomethingActive(["/admin/extension/license/support"])&&!this.isMarketplace()}),href:"#",id:"settings-navigation-configuration",onClick:t},Object(s.translate)("sidebar.project_settings"),r.createElement(y.a,{className:"little-spacer-left"})))}renderProjectsTab(){return r.createElement(g.a,{overlay:r.createElement("ul",{className:"menu"},r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/projects_management"},Object(s.translate)("management"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/background_tasks"},Object(s.translate)("background_tasks.page")))),tagName:"li"},({onToggleClick:t,open:e})=>r.createElement("a",{"aria-expanded":e,"aria-haspopup":"menu",role:"button",className:f("dropdown-toggle",{active:e||this.isProjectsActive()}),href:"#",onClick:t},Object(s.translate)("sidebar.projects"),r.createElement(y.a,{className:"little-spacer-left"})))}renderSecurityTab(){return r.createElement(g.a,{overlay:r.createElement("ul",{className:"menu"},r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/users"},Object(s.translate)("users.page"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/groups"},Object(s.translate)("user_groups.page"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/permissions"},Object(s.translate)("global_permissions.page"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/permission_templates"},Object(s.translate)("permission_templates")))),tagName:"li"},({onToggleClick:t,open:e})=>r.createElement("a",{"aria-expanded":e,"aria-haspopup":"menu",role:"button",className:f("dropdown-toggle",{active:e||this.isSecurityActive()}),href:"#",onClick:t},Object(s.translate)("sidebar.security"),r.createElement(y.a,{className:"little-spacer-left"})))}render(){const{extensions:t,pendingPlugins:e}=this.props,n=t.find(t=>"license/support"===t.key),a=e.installing.length+e.removing.length+e.updating.length,i=x.rawSizes.contextNavHeightRaw;let o;return"RESTARTING"===this.props.systemStatus?o=r.createElement(D,null):a>0&&(o=r.createElement(A,{fetchSystemStatus:this.props.fetchSystemStatus,pending:e,refreshPending:this.props.fetchPendingPlugins,systemStatus:this.props.systemStatus})),r.createElement(j.a,{height:o?i+30:i,id:"context-navigation",notif:o},r.createElement("header",{className:"navbar-context-header"},r.createElement("h1",null,Object(s.translate)("layout.settings"))),r.createElement(S.a,null,this.renderConfigurationTab(),this.renderSecurityTab(),this.renderProjectsTab(),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/system"},Object(s.translate)("sidebar.system"))),r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/marketplace"},Object(s.translate)("marketplace.page"))),n&&r.createElement("li",null,r.createElement(h.a,{activeClassName:"active",to:"/admin/extension/license/support"},Object(s.translate)("support")))))}}M.defaultProps={extensions:[]};class R extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={pendingPlugins:d.b,systemStatus:d.c},this.fetchNavigationSettings=()=>{Object(o.c)().then(t=>this.props.setAdminPages(t.extensions),()=>{})},this.fetchPendingPlugins=()=>{Object(c.e)().then(t=>{this.mounted&&this.setState({pendingPlugins:t})},()=>{})},this.fetchSystemStatus=()=>{Object(l.c)().then(({status:t})=>{this.mounted&&(this.setState({systemStatus:t}),"RESTARTING"===t&&this.waitRestartingDone())},()=>{})},this.waitRestartingDone=()=>{Object(l.h)().then(({status:t})=>{this.mounted&&(this.setState({systemStatus:t}),document.location.reload())},()=>{})}}componentDidMount(){this.mounted=!0,this.props.appState.canAdmin?(this.fetchNavigationSettings(),this.fetchPendingPlugins(),this.fetchSystemStatus()):Object(u.a)()}componentWillUnmount(){this.mounted=!1}render(){const{adminPages:t}=this.props.appState;if(!t)return null;const{pendingPlugins:e,systemStatus:n}=this.state,i=Object(s.translate)("layout.settings");return r.createElement("div",null,r.createElement(a.a,{defaultTitle:i,defer:!1,titleTemplate:"%s - ".concat(i)}),r.createElement(M,{extensions:t,fetchPendingPlugins:this.fetchPendingPlugins,fetchSystemStatus:this.fetchSystemStatus,location:this.props.location,pendingPlugins:e,systemStatus:n}),r.createElement(d.a.Provider,{value:{fetchSystemStatus:this.fetchSystemStatus,fetchPendingPlugins:this.fetchPendingPlugins,pendingPlugins:e,systemStatus:n}},this.props.children))}}const B={setAdminPages:p.d};e.default=Object(i.b)(t=>({appState:Object(m.getAppState)(t)}),B)(R)},332:function(t,e,n){"use strict";var r,a=this&&this.__extends||(r=function(t,e){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}r(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,r=arguments.length;n<r;n++)for(var a in e=arguments[n])Object.prototype.hasOwnProperty.call(e,a)&&(t[a]=e[a]);return t}).apply(this,arguments)},s=this&&this.__rest||function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(t);a<r.length;a++)e.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(t,r[a])&&(n[r[a]]=t[r[a]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var o=n(2),c=n(331),l=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={submitting:!1},e.stopSubmitting=function(){e.mounted&&e.setState({submitting:!1})},e.handleCloseClick=function(t){t&&(t.preventDefault(),t.currentTarget.blur()),e.props.onClose()},e.handleFormSubmit=function(t){t.preventDefault(),e.submit()},e.handleSubmitClick=function(t){t&&(t.preventDefault(),t.currentTarget.blur()),e.submit()},e.submit=function(){var t=e.props.onSubmit();t&&(e.setState({submitting:!0}),t.then(e.stopSubmitting,e.stopSubmitting))},e}return a(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){var t=this.props,e=t.children,n=t.header,r=t.onClose,a=(t.onSubmit,s(t,["children","header","onClose","onSubmit"]));return o.createElement(c.default,i({contentLabel:n,onRequestClose:r},a),e({onCloseClick:this.handleCloseClick,onFormSubmit:this.handleFormSubmit,onSubmitClick:this.handleSubmitClick,submitting:this.state.submitting}))},e}(o.Component);e.default=l},358:function(t,e,n){"use strict";var r,a=this&&this.__extends||(r=function(t,e){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}r(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,r=arguments.length;n<r;n++)for(var a in e=arguments[n])Object.prototype.hasOwnProperty.call(e,a)&&(t[a]=e[a]);return t}).apply(this,arguments)};Object.defineProperty(e,"__esModule",{value:!0});var s=n(2),o=n(31),c=n(319),l=n(312),u=n(441),p=n(332),m=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.handleSubmit=function(){var t=e.props.onConfirm(e.props.confirmData);return t?t.then(e.props.onClose,(function(){})):void e.props.onClose()},e.renderModalContent=function(t){var n=t.onCloseClick,r=t.onFormSubmit,a=t.submitting,i=e.props,p=i.children,m=i.confirmButtonText,d=i.confirmDisable,f=i.header,h=i.headerDescription,b=i.isDestructive,g=i.cancelButtonText,v=void 0===g?o.translate("cancel"):g;return s.createElement(u.default,null,s.createElement("form",{onSubmit:r},s.createElement("header",{className:"modal-head"},s.createElement("h2",null,f),h),s.createElement("div",{className:"modal-body"},p),s.createElement("footer",{className:"modal-foot"},s.createElement(c.default,{className:"spacer-right",loading:a}),s.createElement(l.SubmitButton,{autoFocus:!0,className:b?"button-red":void 0,disabled:a||d},m),s.createElement(l.ResetButtonLink,{disabled:a,onClick:n},v))))},e}return a(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){var t=this.props,e={header:t.header,onClose:t.onClose,noBackdrop:t.noBackdrop,size:t.size};return s.createElement(p.default,i({onSubmit:this.handleSubmit},e),this.renderModalContent)},e}(s.PureComponent);e.default=m},361:function(t,e){t.exports=function(t){return t}},387:function(t,e,n){var r=n(361);t.exports=function(t){var e=r(t),n=e%1;return e==e?n?e-n:e:0}},394:function(t,e,n){"use strict";var r,a=this&&this.__extends||(r=function(t,e){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}r(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,r=arguments.length;n<r;n++)for(var a in e=arguments[n])Object.prototype.hasOwnProperty.call(e,a)&&(t[a]=e[a]);return t}).apply(this,arguments)},s=this&&this.__rest||function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(t);a<r.length;a++)e.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(t,r[a])&&(n[r[a]]=t[r[a]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var o=n(2),c=n(358),l=n(395),u=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.renderConfirmModal=function(t){var n=t.onClose,r=e.props,a=(r.children,r.modalBody),l=r.modalHeader,u=r.modalHeaderDescription,p=s(r,["children","modalBody","modalHeader","modalHeaderDescription"]);return o.createElement(c.default,i({header:l,headerDescription:u,onClose:n},p),a)},e}return a(e,t),e.prototype.render=function(){return o.createElement(l.default,{modal:this.renderConfirmModal},this.props.children)},e}(o.PureComponent);e.default=u},395:function(t,e,n){"use strict";var r,a=this&&this.__extends||(r=function(t,e){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}r(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)});Object.defineProperty(e,"__esModule",{value:!0});var i=n(2),s=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={modal:!1},e.handleButtonClick=function(){e.setState({modal:!0})},e.handleFormSubmit=function(t){t&&t.preventDefault(),e.setState({modal:!0})},e.handleCloseModal=function(){e.mounted&&e.setState({modal:!1})},e}return a(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){return i.createElement(i.Fragment,null,this.props.children({onClick:this.handleButtonClick,onFormSubmit:this.handleFormSubmit}),this.state.modal&&this.props.modal({onClose:this.handleCloseModal}))},e}(i.PureComponent);e.default=s},420:function(t,e){t.exports=function(t,e,n,r){for(var a=t.length,i=n+(r?1:-1);r?i--:++i<a;)if(e(t[i],i,t))return i;return-1}},519:function(t,e,n){"use strict";var r,a;function i(t){return void 0!==t.release}function s(t){return function(t){return void 0!==t.version}(t)&&void 0!==t.updatedAt}n.d(e,"a",(function(){return r})),n.d(e,"b",(function(){return a})),n.d(e,"c",(function(){return i})),n.d(e,"d",(function(){return s})),function(t){t.Bundled="BUNDLED",t.External="EXTERNAL"}(r||(r={})),function(t){t.Accepted="ACCEPTED",t.NotAccepted="NOT_ACCEPTED",t.Required="REQUIRED"}(a||(a={}))},535:function(t,e,n){"use strict";n.d(e,"g",(function(){return i})),n.d(e,"b",(function(){return s})),n.d(e,"c",(function(){return o})),n.d(e,"d",(function(){return c})),n.d(e,"a",(function(){return l})),n.d(e,"e",(function(){return u})),n.d(e,"f",(function(){return p})),n.d(e,"h",(function(){return m}));var r=n(9),a=n(324);function i(t){return Object(r.post)("/api/system/change_log_level",{level:t}).catch(a.a)}function s(){return Object(r.getJSON)("/api/system/info").catch(a.a)}function o(){return Object(r.getJSON)("/api/system/status")}function c(){return Object(r.getJSON)("/api/system/upgrades")}function l(){return Object(r.getJSON)("/api/system/db_migration_status")}function u(){return Object(r.postJSON)("/api/system/migrate_db")}function p(){return Object(r.post)("/api/system/restart").catch(a.a)}function m(){return Object(r.requestTryAndRepeatUntil)(o,{max:-1,slowThreshold:-15},({status:t})=>"UP"===t)}},563:function(t,e,n){"use strict";n.d(e,"a",(function(){return i})),n.d(e,"b",(function(){return s})),n.d(e,"c",(function(){return o}));var r=n(9),a=n(324);function i(t){return Object(r.getJSON)("/api/navigation/component",t).catch(a.a)}function s(){return Object(r.getJSON)("/api/navigation/marketplace").catch(a.a)}function o(){return Object(r.getJSON)("/api/navigation/settings").catch(a.a)}},567:function(t,e,n){var r=n(420),a=n(329),i=n(387),s=Math.max,o=Math.min;t.exports=function(t,e,n){var c=null==t?0:t.length;if(!c)return-1;var l=c-1;return void 0!==n&&(l=i(n),l=n<0?s(c+l,0):o(l,c-1)),r(t,a(e,3),l,!0)}},637:function(t,e,n){"use strict";n.d(e,"a",(function(){return o}));var r=n(36),a=n.n(r),i=n(559),s=n(414);function o(){const t=Object(s.default)(),e=a()(),n=window.location.pathname+window.location.search+window.location.hash;t.dispatch(Object(i.c)()),e.replace({pathname:"/sessions/new",query:{return_to:n}})}},638:function(t,e,n){"use strict";n.d(e,"b",(function(){return m})),n.d(e,"e",(function(){return d})),n.d(e,"c",(function(){return v})),n.d(e,"d",(function(){return y})),n.d(e,"f",(function(){return O})),n.d(e,"g",(function(){return j})),n.d(e,"h",(function(){return _})),n.d(e,"i",(function(){return S})),n.d(e,"a",(function(){return E}));var r=n(567),a=n.n(r),i=n(9),s=n(402),o=n(324),c=n(519);function l(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,r)}return n}function u(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?l(Object(n),!0).forEach((function(e){p(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):l(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}function p(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function m(){return Object(i.getJSON)("/api/plugins/available").catch(o.a)}function d(){return Object(i.getJSON)("/api/plugins/pending").catch(o.a)}function f(t){if(!t)return[];return["COMPATIBLE","REQUIRES_SYSTEM_UPGRADE","DEPS_REQUIRE_SYSTEM_UPGRADE"].map(e=>{const n=a()(t,t=>t.status===e);return n>-1?t[n]:void 0}).filter(s.isDefined)}function h(t,e){if(!e)return t;const n=e.indexOf(t);return u({},t,{previousUpdates:n>0?e.slice(0,n):[]})}function b(t=c.a.External){return Object(i.getJSON)("/api/plugins/installed",{f:"category",type:t})}function g(){return Object(i.getJSON)("/api/plugins/updates")}function v(t=c.a.External){return b(t).then(({plugins:t})=>t,o.a)}function y(){return Promise.all([b(),g()]).then(([t,e])=>t.plugins.map(t=>{const n=e.plugins.find(e=>e.key===t.key);return n?u({},n,{},t,{updates:f(n.updates).map(t=>h(t,n.updates))}):t})).catch(o.a)}function O(){return Promise.all([g(),b()]).then(([t,e])=>t.plugins.map(t=>{const n=f(t.updates).map(e=>h(e,t.updates)),r=e.plugins.find(e=>e.key===t.key);return r?u({},r,{},t,{updates:n}):u({},t,{updates:n})})).catch(o.a)}function j(t){return Object(i.post)("/api/plugins/install",t).catch(o.a)}function _(t){return Object(i.post)("/api/plugins/uninstall",t).catch(o.a)}function S(t){return Object(i.post)("/api/plugins/update",t).catch(o.a)}function E(){return Object(i.post)("/api/plugins/cancel_all").catch(o.a)}},700:function(t,e,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(t){for(var e,n=1,r=arguments.length;n<r;n++)for(var a in e=arguments[n])Object.prototype.hasOwnProperty.call(e,a)&&(t[a]=e[a]);return t}).apply(this,arguments)},a=this&&this.__rest||function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(t);a<r.length;a++)e.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(t,r[a])&&(n[r[a]]=t[r[a]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var i=n(311),s=n(2);n(701),e.default=function(t){var e=t.children,n=t.className,o=a(t,["children","className"]);return s.createElement("ul",r({},o,{className:i("navbar-tabs",n)}),e)}},701:function(t,e,n){var r=n(313),a=n(702);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[t.i,a,""]]);var i={insert:"head",singleton:!1},s=(r(a,i),a.locals?a.locals:{});t.exports=s},702:function(t,e,n){(e=n(314)(!1)).push([t.i,".navbar-tabs{display:flex;align-items:center;clear:left;height:24px;margin-top:8px}.navbar-tabs>li+li{margin-left:20px}.navbar-tabs>li>a{display:block;height:24px;line-height:16px;padding-top:2px;border-bottom:3px solid transparent;box-sizing:border-box;color:#333;transition:none}.navbar-tabs>li>a.active,.navbar-tabs>li>a:focus,.navbar-tabs>li>a:hover{border-bottom-color:#4b9fd5}",""]),t.exports=e},731:function(t,e,n){"use strict";n.d(e,"b",(function(){return a})),n.d(e,"c",(function(){return i}));var r=n(2);const a={installing:[],removing:[],updating:[]},i="UP",s=r.createContext({fetchSystemStatus:()=>{},fetchPendingPlugins:()=>{},pendingPlugins:a,systemStatus:i});e.a=s},840:function(t,e,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(t){for(var e,n=1,r=arguments.length;n<r;n++)for(var a in e=arguments[n])Object.prototype.hasOwnProperty.call(e,a)&&(t[a]=e[a]);return t}).apply(this,arguments)},a=this&&this.__rest||function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var a=0;for(r=Object.getOwnPropertySymbols(t);a<r.length;a++)e.indexOf(r[a])<0&&Object.prototype.propertyIsEnumerable.call(t,r[a])&&(n[r[a]]=t[r[a]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var i=n(311),s=n(2);n(841);var o=n(517);e.default=function(t){var e=t.className,n=a(t,["className"]);return s.createElement(o.default,r({className:i("navbar-context",e)},n))}},841:function(t,e,n){var r=n(313),a=n(842);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[t.i,a,""]]);var i={insert:"head",singleton:!1},s=(r(a,i),a.locals?a.locals:{});t.exports=s},842:function(t,e,n){(e=n(314)(!1)).push([t.i,".navbar-context,.navbar-context .navbar-inner{background-color:#fff;z-index:420}.navbar-context .navbar-inner{padding-top:8px;border-bottom:1px solid #e6e6e6}.navbar-context .navbar-inner-with-notif{border-bottom:none}.navbar-context-justified{display:flex;justify-content:space-between}.navbar-context-header{display:flex;align-items:center;min-width:0;height:32px;font-size:16px}.navbar-context-header>:not(.navbar-context-header-breadcrumb-link){flex-shrink:0}.navbar-context-header-breadcrumb-link{min-width:0;overflow:hidden;text-overflow:ellipsis;white-space:nowrap}.navbar-context-header .slash-separator{margin-left:8px;margin-right:8px;font-size:24px}.navbar-context-header .slash-separator:after{color:rgba(68,68,68,.2)}.navbar-context-meta{display:flex;align-items:center;height:32px;padding-left:20px;color:#666;font-size:12px;text-align:right}.navbar-context-meta-secondary{position:absolute;top:34px;right:0;padding:0 20px;white-space:nowrap}.navbar-context-description{display:inline-block;line-height:24px;margin-left:8px;padding-top:4px;color:#666;font-size:12px}",""]),t.exports=e},862:function(t,e,n){"use strict";n.d(e,"a",(function(){return u}));var r=n(311),a=n(2),i=n(312),s=n(394),o=n.n(s),c=n(31),l=n(535);class u extends a.PureComponent{constructor(){super(...arguments),this.handleConfirm=()=>Object(l.f)().then(this.props.fetchSystemStatus)}render(){const{className:t,systemStatus:e}=this.props;return a.createElement(o.a,{confirmButtonText:Object(c.translate)("restart"),modalBody:a.createElement(a.Fragment,null,a.createElement("p",{className:"spacer-top spacer-bottom"},Object(c.translate)("system.are_you_sure_to_restart")),a.createElement("p",null,Object(c.translate)("system.forcing_shutdown_not_recommended"))),modalHeader:Object(c.translate)("system.restart_server"),onConfirm:this.handleConfirm},({onClick:n})=>a.createElement(i.Button,{className:r("button-red",t),disabled:"UP"!==e,onClick:n},"RESTARTING"===e?Object(c.translate)("system.restart_in_progress"):Object(c.translate)("system.restart_server")))}}}}]);
//# sourceMappingURL=294.m.ce3ccc28.chunk.js.map
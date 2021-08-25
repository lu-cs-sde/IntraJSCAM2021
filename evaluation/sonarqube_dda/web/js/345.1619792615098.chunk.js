(window.webpackJsonp=window.webpackJsonp||[]).push([[345],{1061:function(e,t,n){"use strict";var r=n(774);t.a=function(e){return/^(\/|scm:)/.test(e)||!!Object(r.isWebUri)(e)}},1191:function(e,t,n){"use strict";n.d(t,"c",(function(){return a})),n.d(t,"b",(function(){return c})),n.d(t,"a",(function(){return l}));var r=n(49),o=n(673);function a(e){return Object(r.getJSON)("/api/project_links/search",{projectKey:e}).then((function(e){return e.links}),o.a)}function c(e){return Object(r.post)("/api/project_links/delete",{id:e}).catch(o.a)}function l(e){return Object(r.postJSON)("/api/project_links/create",e).then((function(e){return e.link}),o.a)}},2212:function(e,t,n){"use strict";n.r(t);var r,o=n(13),a=n(684),c=n(668),l=n.n(c),i=n(176),s=n(1191),u=n(661),p=n(681),m=n.n(p),d=n(688),f=n.n(d),h=n(695),b=n.n(h),y=(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),j=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.state={name:"",url:""},t.handleSubmit=function(){return t.props.onSubmit(t.state.name,t.state.url).then(t.props.onClose)},t.handleNameChange=function(e){t.setState({name:e.currentTarget.value})},t.handleUrlChange=function(e){t.setState({url:e.currentTarget.value})},t}return y(t,e),t.prototype.render=function(){var e=this,t=Object(i.translate)("project_links.create_new_project_link");return o.createElement(m.a,{header:t,onClose:this.props.onClose,onSubmit:this.handleSubmit,size:"small"},(function(n){var r=n.onCloseClick,a=n.onFormSubmit,c=n.submitting;return o.createElement("form",{onSubmit:a},o.createElement("header",{className:"modal-head"},o.createElement("h2",null,t)),o.createElement("div",{className:"modal-body"},o.createElement(b.a,{className:"modal-field"}),o.createElement("div",{className:"modal-field"},o.createElement("label",{htmlFor:"create-link-name"},Object(i.translate)("project_links.name"),o.createElement(f.a,null)),o.createElement("input",{autoFocus:!0,id:"create-link-name",maxLength:128,name:"name",onChange:e.handleNameChange,required:!0,type:"text",value:e.state.name})),o.createElement("div",{className:"modal-field"},o.createElement("label",{htmlFor:"create-link-url"},Object(i.translate)("project_links.url"),o.createElement(f.a,null)),o.createElement("input",{id:"create-link-url",maxLength:128,name:"url",onChange:e.handleUrlChange,required:!0,type:"text",value:e.state.url}))),o.createElement("footer",{className:"modal-foot"},o.createElement(l.a,{className:"spacer-right",loading:c}),o.createElement(u.SubmitButton,{disabled:c,id:"create-link-confirm"},Object(i.translate)("create")),o.createElement(u.ResetButtonLink,{disabled:c,onClick:r},Object(i.translate)("cancel"))))}))},t}(o.PureComponent),_=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),k=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={creationModal:!1},t.handleCreateClick=function(){t.setState({creationModal:!0})},t.handleCreationModalClose=function(){t.mounted&&t.setState({creationModal:!1})},t}return _(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return o.createElement(o.Fragment,null,o.createElement("header",{className:"page-header"},o.createElement("h1",{className:"page-title"},Object(i.translate)("project_links.page")),o.createElement("div",{className:"page-actions"},o.createElement(u.Button,{id:"create-project-link",onClick:this.handleCreateClick},Object(i.translate)("create"))),o.createElement("div",{className:"page-description"},Object(i.translate)("project_links.page.description"))),this.state.creationModal&&o.createElement(j,{onClose:this.handleCreationModalClose,onSubmit:this.props.onCreate}))},t}(o.PureComponent),O=n(945),E=n(742),v=n.n(E),g=n(1056),N=n.n(g),C=n(1061),w=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),S=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.renderNameForProvided=function(e){return o.createElement("div",{className:"display-inline-block text-top"},o.createElement("div",null,o.createElement("span",{className:"js-name"},Object(O.a)(e))),o.createElement("div",{className:"note little-spacer-top"},o.createElement("span",{className:"js-type"},"sonar.links."+e.type)))},t.renderName=function(e){return o.createElement("div",null,o.createElement(N.a,{className:"little-spacer-right",type:e.type}),Object(O.b)(e)?t.renderNameForProvided(e):o.createElement("div",{className:"display-inline-block text-top"},o.createElement("span",{className:"js-name"},e.name)))},t.renderDeleteButton=function(e){return Object(O.b)(e)?null:o.createElement(v.a,{confirmButtonText:Object(i.translate)("delete"),confirmData:e.id,isDestructive:!0,modalBody:Object(i.translateWithParameters)("project_links.are_you_sure_to_delete_x_link",e.name),modalHeader:Object(i.translate)("project_links.delete_project_link"),onConfirm:t.props.onDelete},(function(e){var t=e.onClick;return o.createElement(u.Button,{className:"button-red js-delete-button",onClick:t},Object(i.translate)("delete"))}))},t}return w(t,e),t.prototype.render=function(){var e=this.props.link;return o.createElement("tr",{"data-name":e.name},o.createElement("td",{className:"nowrap"},this.renderName(e)),o.createElement("td",{className:"nowrap js-url"},Object(C.a)(e.url)?o.createElement("a",{href:e.url,rel:"nofollow noreferrer noopener",target:"_blank"},e.url):e.url),o.createElement("td",{className:"thin nowrap"},this.renderDeleteButton(e)))},t}(o.PureComponent),P=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),D=function(e){function t(){return null!==e&&e.apply(this,arguments)||this}return P(t,e),t.prototype.renderHeader=function(){return o.createElement("thead",null,o.createElement("tr",null,o.createElement("th",{className:"nowrap"},Object(i.translate)("project_links.name")),o.createElement("th",{className:"nowrap width-100"},Object(i.translate)("project_links.url")),o.createElement("th",{className:"thin"}," ")))},t.prototype.render=function(){var e=this;if(!this.props.links.length)return o.createElement("div",{className:"note"},Object(i.translate)("no_results"));var t=Object(O.c)(this.props.links).map((function(t){return o.createElement(S,{key:t.id,link:t,onDelete:e.props.onDelete})}));return o.createElement("div",{className:"boxed-group boxed-group-inner"},o.createElement("table",{className:"data zebra",id:"project-links"},this.renderHeader(),o.createElement("tbody",null,t)))},t}(o.PureComponent),x=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),L=function(){for(var e=0,t=0,n=arguments.length;t<n;t++)e+=arguments[t].length;var r=Array(e),o=0;for(t=0;t<n;t++)for(var a=arguments[t],c=0,l=a.length;c<l;c++,o++)r[o]=a[c];return r},B=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={loading:!0},t.fetchLinks=function(){t.setState({loading:!0}),Object(s.c)(t.props.component.key).then((function(e){t.mounted&&t.setState({links:e,loading:!1})}),(function(){t.mounted&&t.setState({loading:!1})}))},t.handleCreateLink=function(e,n){return Object(s.a)({name:e,projectKey:t.props.component.key,url:n}).then((function(e){t.mounted&&t.setState((function(t){var n=t.links;return{links:L(void 0===n?[]:n,[e])}}))}))},t.handleDeleteLink=function(e){return Object(s.b)(e).then((function(){t.mounted&&t.setState((function(t){var n=t.links;return{links:(void 0===n?[]:n).filter((function(t){return t.id!==e}))}}))}))},t}return x(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.fetchLinks()},t.prototype.componentDidUpdate=function(e){e.component.key!==this.props.component.key&&this.fetchLinks()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return o.createElement("div",{className:"page page-limited"},o.createElement(a.a,{defer:!1,title:Object(i.translate)("project_links.page")}),o.createElement(k,{onCreate:this.handleCreateLink}),o.createElement(l.a,{loading:this.state.loading},this.state.links&&o.createElement(D,{links:this.state.links,onDelete:this.handleDeleteLink})))},t}(o.PureComponent);t.default=B},945:function(e,t,n){"use strict";n.d(t,"b",(function(){return u})),n.d(t,"c",(function(){return p})),n.d(t,"a",(function(){return m}));var r=n(679),o=n.n(r),a=n(877),c=n.n(a),l=n(176),i=function(){for(var e=0,t=0,n=arguments.length;t<n;t++)e+=arguments[t].length;var r=Array(e),o=0;for(t=0;t<n;t++)for(var a=arguments[t],c=0,l=a.length;c<l;c++,o++)r[o]=a[c];return r},s=["homepage","ci","issue","scm","scm_dev"];function u(e){return s.includes(e.type)}function p(e){var t=c()(e,u),n=t[0],r=t[1];return i(o()(n,(function(e){return s.indexOf(e.type)})),o()(r,(function(e){return e.name&&e.name.toLowerCase()})))}function m(e){return u(e)?Object(l.translate)("project_links",e.type):e.name}}}]);
//# sourceMappingURL=345.1619792615098.chunk.js.map
(window.webpackJsonp=window.webpackJsonp||[]).push([[334],{2217:function(e,t,n){"use strict";n.r(t);var r,a=n(13),o=n(684),c=n(668),i=n.n(c),s=n(176),u=n(801),l=n(665),p=n(667),m=n(661),f=n(703),y=(r=function(e,t){return(r=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}r(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),d=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={encrypting:!1,generating:!1,value:""},t.handleChange=function(e){t.setState({value:e.currentTarget.value})},t.handleEncrypt=function(e){e.preventDefault(),t.setState({encrypting:!0}),Object(u.b)(t.state.value).then((function(e){var n=e.encryptedValue;t.mounted&&t.setState({encryptedValue:n,encrypting:!1})}),(function(){t.mounted&&t.setState({encrypting:!1})}))},t.handleGenerateSecretKey=function(e){e.preventDefault(),t.setState({generating:!0}),t.props.generateSecretKey().then(t.stopGenerating,t.stopGenerating)},t.stopGenerating=function(){t.mounted&&t.setState({generating:!1})},t}return y(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.state,t=e.encryptedValue,n=e.encrypting,r=e.generating;return a.createElement("div",{id:"encryption-form-container"},a.createElement("div",{className:"spacer-bottom"},Object(s.translate)("encryption.form_intro")),a.createElement("form",{className:"big-spacer-bottom",id:"encryption-form",onSubmit:this.handleEncrypt},a.createElement("textarea",{autoFocus:!0,className:"abs-width-600",id:"encryption-form-value",onChange:this.handleChange,required:!0,rows:5,value:this.state.value}),a.createElement("div",{className:"spacer-top"},a.createElement(m.SubmitButton,{disabled:n||r},Object(s.translate)("encryption.encrypt")),a.createElement(i.a,{className:"spacer-left",loading:n}))),t&&a.createElement("div",null,a.createElement("span",{className:"little-spacer-right"},Object(s.translate)("encryption.encrypted_value")),a.createElement("input",{className:"input-clear input-code input-super-large",id:"encrypted-value",readOnly:!0,type:"text",value:t}),a.createElement(f.ClipboardButton,{className:"little-spacer-left",copyValue:t})),a.createElement("form",{className:"huge-spacer-top bordered-top",id:"encryption-new-key-form",onSubmit:this.handleGenerateSecretKey},a.createElement("p",{className:"big-spacer-top spacer-bottom"},a.createElement(l.FormattedMessage,{defaultMessage:Object(s.translate)("encryption.form_note"),id:"encryption.form_note",values:{moreInformationLink:a.createElement(p.c,{to:"/documentation/instance-administration/security/",target:"_blank"},Object(s.translate)("more_information"))}})),a.createElement(m.SubmitButton,{disabled:r||n},Object(s.translate)("encryption.generate_new_secret_key")," "),a.createElement(i.a,{className:"spacer-left",loading:r})))},t}(a.PureComponent),g=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),b=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={submitting:!1},t.handleSubmit=function(e){e.preventDefault(),t.setState({submitting:!0}),t.props.generateSecretKey().then(t.stopSubmitting,t.stopSubmitting)},t.stopSubmitting=function(){t.mounted&&t.setState({submitting:!1})},t}return g(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.props.secretKey,t=this.state.submitting;return a.createElement("div",{id:"generate-secret-key-form-container"},e?a.createElement(a.Fragment,null,a.createElement("div",{className:"big-spacer-bottom"},a.createElement("h3",{className:"spacer-bottom"},Object(s.translate)("encryption.secret_key")),a.createElement("input",{className:"input-clear input-code input-large",id:"secret-key",readOnly:!0,type:"text",value:e}),a.createElement(f.ClipboardButton,{className:"little-spacer-left",copyValue:e})),a.createElement("h3",{className:"spacer-bottom"},Object(s.translate)("encryption.how_to_use")),a.createElement("div",{className:"markdown"},a.createElement("ul",null,a.createElement("li",null,a.createElement(l.FormattedMessage,{defaultMessage:Object(s.translate)("encryption.how_to_use.content1"),id:"encryption.how_to_use.content1",values:{secret_file:a.createElement("code",null,"~/.sonar/sonar-secret.txt"),property:a.createElement("code",null,"sonar.secretKeyPath"),propreties_file:a.createElement("code",null,"conf/sonar.properties")}})),a.createElement("li",null,Object(s.translate)("encryption.how_to_use.content2")),a.createElement("li",null,a.createElement(l.FormattedMessage,{defaultMessage:Object(s.translate)("encryption.how_to_use.content3"),id:"encryption.how_to_use.content3",values:{property:a.createElement("code",null,"sonar.secretKeyPath")}})),a.createElement("li",null,Object(s.translate)("encryption.how_to_use.content4"))))):a.createElement("form",{id:"generate-secret-key-form",onSubmit:this.handleSubmit},a.createElement("p",{className:"spacer-bottom"},a.createElement(l.FormattedMessage,{defaultMessage:Object(s.translate)("encryption.secret_key_description"),id:"encryption.secret_key_description",values:{moreInformationLink:a.createElement(p.c,{to:"/documentation/instance-administration/security/",target:"_blank"},Object(s.translate)("more_information"))}})),a.createElement(m.SubmitButton,{disabled:t},Object(s.translate)("encryption.generate_secret_key")),a.createElement(i.a,{className:"spacer-left",loading:t})))},t}(a.PureComponent),h=function(){var e=function(t,n){return(e=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)Object.prototype.hasOwnProperty.call(t,n)&&(e[n]=t[n])})(t,n)};return function(t,n){function r(){this.constructor=t}e(t,n),t.prototype=null===n?Object.create(n):(r.prototype=n.prototype,new r)}}(),_=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.state={loading:!0},t.mounted=!1,t.checkSecretKey=function(){Object(u.a)().then((function(e){var n=e.secretKeyAvailable;t.mounted&&t.setState({loading:!1,secretKeyAvailable:n})}),(function(){t.mounted&&t.setState({loading:!1})}))},t.generateSecretKey=function(){return Object(u.c)().then((function(e){var n=e.secretKey;t.mounted&&t.setState({secretKey:n,secretKeyAvailable:!1})}))},t}return h(t,e),t.prototype.componentDidMount=function(){this.mounted=!0,this.checkSecretKey()},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.state,t=e.loading,n=e.secretKey,r=e.secretKeyAvailable;return a.createElement("div",{className:"page page-limited",id:"encryption-page"},a.createElement(o.a,{defer:!1,title:Object(s.translate)("property.category.security.encryption")}),a.createElement("header",{className:"page-header"},a.createElement("h1",{className:"page-title"},Object(s.translate)("property.category.security.encryption")),a.createElement(i.a,{loading:t})),!t&&!r&&a.createElement(b,{generateSecretKey:this.generateSecretKey,secretKey:n}),r&&a.createElement(d,{generateSecretKey:this.generateSecretKey}))},t}(a.PureComponent);t.default=_},770:function(e,t,n){var r=n(685),a=n(678),o=n(861),c=n(863);e.exports=function(e,t){if(null==e)return{};var n=r(c(e),(function(e){return[e]}));return t=a(t),o(e,n,(function(e,n){return t(e,n[0])}))}},786:function(e,t,n){var r=n(678),a=n(787),o=n(770);e.exports=function(e,t){return o(e,a(r(t)))}},787:function(e,t){e.exports=function(e){if("function"!=typeof e)throw new TypeError("Expected a function");return function(){var t=arguments;switch(t.length){case 0:return!e.call(this);case 1:return!e.call(this,t[0]);case 2:return!e.call(this,t[0],t[1]);case 3:return!e.call(this,t[0],t[1],t[2])}return!e.apply(this,t)}}},801:function(e,t,n){"use strict";n.d(t,"d",(function(){return s})),n.d(t,"e",(function(){return u})),n.d(t,"h",(function(){return l})),n.d(t,"i",(function(){return p})),n.d(t,"f",(function(){return m})),n.d(t,"g",(function(){return f})),n.d(t,"a",(function(){return y})),n.d(t,"c",(function(){return d})),n.d(t,"b",(function(){return g}));var r=n(786),a=n.n(r),o=n(49),c=n(673),i=n(780);function s(e){return Object(o.getJSON)("/api/settings/list_definitions",{component:e}).then((function(e){return e.definitions}),c.a)}function u(e){return Object(o.getJSON)("/api/settings/values",e).then((function(e){return e.settings}))}function l(e,t,n){var r={key:e.key,component:n};return Object(i.k)(e)&&e.multiValues?r.values=t:"PROPERTY_SET"===e.type?r.fieldValues=t.map((function(e){return a()(e,(function(e){return null==e}))})).map(JSON.stringify):r.value=t,Object(o.post)("/api/settings/set",r)}function p(e){return Object(o.post)("/api/settings/set",e).catch(c.a)}function m(e){return Object(o.post)("/api/settings/reset",e)}function f(e,t,n){return Object(o.post)("/api/emails/send",{to:e,subject:t,message:n})}function y(){return Object(o.getJSON)("/api/settings/check_secret_key").catch(c.a)}function d(){return Object(o.postJSON)("/api/settings/generate_secret_key").catch(c.a)}function g(e){return Object(o.postJSON)("/api/settings/encrypt",{value:e}).catch(c.a)}}}]);
//# sourceMappingURL=334.1619792615098.chunk.js.map
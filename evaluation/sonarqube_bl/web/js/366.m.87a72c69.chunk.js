(window.webpackJsonp=window.webpackJsonp||[]).push([[366],{1869:function(e,t,a){"use strict";a.r(t),a.d(t,"default",(function(){return O}));var r=a(2),n=a(335),l=a(318),c=a(366),s=a.n(c),i=a(31),o=a(576),u=a(1160),p=a(686),m=a(482);class f extends r.PureComponent{render(){const{profile:e}=this.props;return r.createElement("header",{className:"page-header quality-profile-header"},r.createElement("div",{className:"note spacer-bottom"},r.createElement(l.a,{className:"text-muted",to:m.a},Object(i.translate)("quality_profiles.page"))," / ",r.createElement(l.c,{className:"text-muted",to:Object(m.e)(e.language)},e.languageName)),r.createElement("h1",{className:"page-title"},r.createElement(p.a,{className:"link-base-color",language:e.language,name:e.name},r.createElement("span",null,e.name)),e.isBuiltIn&&r.createElement(o.a,{className:"spacer-left",tooltip:!1})),r.createElement("div",{className:"pull-right"},r.createElement("ul",{className:"list-inline",style:{lineHeight:"24px"}},r.createElement("li",{className:"small spacer-right"},Object(i.translate)("quality_profiles.updated_")," ",r.createElement(s.a,{date:e.rulesUpdatedAt})),r.createElement("li",{className:"small big-spacer-right"},Object(i.translate)("quality_profiles.used_")," ",r.createElement(s.a,{date:e.lastUsed})),r.createElement("li",null,r.createElement(l.c,{className:"button",to:Object(m.b)(e.name,e.language)},Object(i.translate)("changelog"))),r.createElement("li",null,r.createElement(u.a,{className:"pull-left",profile:e,updateProfiles:this.props.updateProfiles})))),e.isBuiltIn&&r.createElement("div",{className:"page-description"},Object(i.translate)("quality_profiles.built_in.description")))}}function d(){return r.createElement("div",{className:"quality-profile-not-found"},r.createElement("div",{className:"note spacer-bottom"},r.createElement(l.a,{className:"text-muted",to:m.a},Object(i.translate)("quality_profiles.page"))),r.createElement("div",null,Object(i.translate)("quality_profiles.not_found")))}function b(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,r)}return a}function g(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function y(e,t){if(null==e)return{};var a,r,n=function(e,t){if(null==e)return{};var a,r,n={},l=Object.keys(e);for(r=0;r<l.length;r++)a=l[r],t.indexOf(a)>=0||(n[a]=e[a]);return n}(e,t);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(e);for(r=0;r<l.length;r++)a=l[r],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(n[a]=e[a])}return n}class O extends r.PureComponent{componentDidMount(){const{location:e,profiles:t,router:a}=this.props;if(e.query.key){const r=t.find(t=>t.key===e.query.key);r&&a.replace({pathname:e.pathname,query:{language:r.language,name:r.name}})}}render(){const e=this.props,{profiles:t,location:a}=e,l=y(e,["profiles","location"]),{key:c,language:s,name:i}=a.query;if(c){return t.find(e=>e.key===a.query.key)?null:r.createElement(d,null)}const o=t.find(e=>e.language===s&&e.name===i);if(!o)return r.createElement(d,null);const u=r.cloneElement(this.props.children,function(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?b(Object(a),!0).forEach((function(t){g(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):b(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}({profile:o,profiles:t},l));return r.createElement("div",{id:"quality-profile"},r.createElement(n.a,{defer:!1,title:o.name}),r.createElement(f,{profile:o,updateProfiles:this.props.updateProfiles}),u)}}}}]);
//# sourceMappingURL=366.m.87a72c69.chunk.js.map
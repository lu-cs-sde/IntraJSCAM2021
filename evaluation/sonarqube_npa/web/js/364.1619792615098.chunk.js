(window.webpackJsonp=window.webpackJsonp||[]).push([[364],{2231:function(e,t,r){"use strict";r.r(t),r.d(t,"default",(function(){return d}));var n,o=r(13),a=r(176),l=r(660),s=r(665),c=r(668),i=r.n(c),u=(n=function(e,t){return(n=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r])})(e,t)},function(e,t){function r(){this.constructor=e}n(e,t),e.prototype=null===t?Object.create(t):(r.prototype=t.prototype,new r)}),p=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.handleMoreClick=function(e){e.preventDefault(),e.stopPropagation(),e.currentTarget.blur();var r=e.currentTarget.dataset.qualifier;r&&t.props.onMoreClick(r)},t.handleMoreMouseEnter=function(e){var r=e.currentTarget.dataset.qualifier;r&&t.props.onSelect("qualifier###"+r)},t}return u(t,e),t.prototype.render=function(){var e=this.props,t=e.loadingMore,r=e.qualifier,n=e.selected;return o.createElement("li",{className:l("menu-footer",{active:n}),key:"more-"+r},o.createElement(i.a,{className:"navbar-search-icon",loading:t===r},o.createElement("a",{className:l({"cursor-not-allowed":!this.props.allowMore}),"data-qualifier":r,href:"#",onClick:this.handleMoreClick,onMouseEnter:this.handleMoreMouseEnter},o.createElement("div",{className:"pull-right text-muted-2 menu-footer-note"},o.createElement(s.FormattedMessage,{defaultMessage:Object(a.translate)("search.show_more.hint"),id:"search.show_more.hint",values:{key:o.createElement("span",{className:"shortcut-button shortcut-button-small"},"Enter")}})),o.createElement("span",null,Object(a.translate)("show_more")))))},t}(o.PureComponent),h=r(1386);function d(e){var t=Object.keys(e.results),r=[];return Object(h.a)(t).forEach((function(t){var n=e.results[t];n.length>0&&r.length>0&&r.push(o.createElement("li",{className:"divider",key:"divider-"+t})),n.length>0&&r.push(o.createElement("li",{className:"menu-header",key:"header-"+t},Object(a.translate)("qualifiers",t))),n.forEach((function(t){return r.push(e.renderResult(t))}));var l=e.more[t];void 0!==l&&l>0&&r.push(o.createElement(p,{allowMore:e.allowMore,key:"more-"+t,loadingMore:e.loadingMore,onMoreClick:e.onMoreClick,onSelect:e.onSelect,qualifier:t,selected:e.selected==="qualifier###"+t}))})),r.length>0?o.createElement("ul",{className:"menu"},r):e.renderNoResults()}}}]);
//# sourceMappingURL=364.1619792615098.chunk.js.map
(window.webpackJsonp=window.webpackJsonp||[]).push([[331],{1854:function(e,t,n){"use strict";n.r(t),n.d(t,"App",(function(){return Q}));var a=n(2),r=n(31),s=n(636),c=n.n(s),l=n(407),o=n.n(l),i=n(528),u=n.n(i),m=n(328),h=n(323),p=n.n(h),d=n(374),b=n.n(d),g=n(366),f=n.n(g),j=n(776),_=n(595),E=n(961),O=n.n(E),k=n(319),y=n.n(k),v=n(624);class N extends a.PureComponent{constructor(e){super(e),this.mounted=!1,this.handleOnChange=()=>{const{branch:e,component:t}=this.props,{excludedFromPurge:n}=this.state,a=!n;this.setState({loading:!0}),Object(v.c)(t.key,e.name,a).then(()=>{this.mounted&&this.setState({excludedFromPurge:a,loading:!1})}).catch(()=>{this.mounted&&this.setState({loading:!1})})},this.state={excludedFromPurge:e.branch.excludedFromPurge,loading:!1}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{branch:e}=this.props,{excludedFromPurge:t,loading:n}=this.state,s=Object(m.g)(e),c=s||n;return a.createElement(a.Fragment,null,a.createElement(O.a,{disabled:c,onChange:this.handleOnChange,value:t}),a.createElement("span",{className:"spacer-left"},a.createElement(y.a,{loading:n})),s&&a.createElement(p.a,{overlay:Object(r.translate)("project_branch_pull_request.branch.auto_deletion.main_branch_tooltip")}))}}var S=a.memo((function(e){const{branchLike:t,component:n,displayPurgeSetting:s,onDelete:c,onRename:l}=e,o=Object(m.b)(t);return a.createElement("tr",null,a.createElement("td",{className:"nowrap hide-overflow"},a.createElement(_.a,{branchLike:t,className:"little-spacer-right"}),a.createElement("span",{title:o},o),a.createElement("span",null,Object(m.g)(t)&&a.createElement("div",{className:"badge spacer-left"},Object(r.translate)("branches.main_branch")))),a.createElement("td",{className:"nowrap"},a.createElement(j.a,{branchLike:t,component:n.key})),a.createElement("td",{className:"nowrap"},a.createElement(f.a,{date:t.analysisDate})),s&&Object(m.f)(t)&&a.createElement("td",{className:"nowrap js-test-purge-toggle-container"},a.createElement(N,{branch:t,component:n})),a.createElement("td",{className:"nowrap"},a.createElement(b.a,null,Object(m.g)(t)?a.createElement(d.ActionsDropdownItem,{className:"js-rename",onClick:l},Object(r.translate)("project_branch_pull_request.branch.rename")):a.createElement(d.ActionsDropdownItem,{className:"js-delete",destructive:!0,onClick:c},Object(r.translate)(Object(m.h)(t)?"project_branch_pull_request.pull_request.delete":"project_branch_pull_request.branch.delete")))))}));var q=a.memo((function(e){const{branchLikes:t,component:n,displayPurgeSetting:s,onDelete:c,onRename:l,title:o}=e;return a.createElement("div",{className:"boxed-group boxed-group-inner"},a.createElement("table",{className:"data zebra zebra-hover fixed"},a.createElement("thead",null,a.createElement("tr",null,a.createElement("th",{className:"nowrap"},o),a.createElement("th",{className:"nowrap",style:{width:"80px"}},Object(r.translate)("status")),a.createElement("th",{className:"nowrap",style:{width:"140px"}},Object(r.translate)("project_branch_pull_request.last_analysis_date")),s&&a.createElement("th",{className:"nowrap",style:{width:"150px"}},a.createElement("div",{className:"display-flex-center"},a.createElement("span",null,Object(r.translate)("project_branch_pull_request.branch.auto_deletion.keep_when_inactive")),a.createElement(p.a,{className:"little-spacer-left",overlay:Object(r.translate)("project_branch_pull_request.branch.auto_deletion.keep_when_inactive.tooltip")}))),a.createElement("th",{className:"nowrap",style:{width:"50px"}},Object(r.translate)("actions")))),a.createElement("tbody",null,t.map(e=>a.createElement(S,{branchLike:e,component:n,displayPurgeSetting:s,key:Object(m.c)(e),onDelete:()=>c(e),onRename:()=>l(e)})))))})),L=n(312),P=n(331),C=n.n(P);class R extends a.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1},this.handleSubmit=e=>{e.preventDefault(),this.setState({loading:!0}),(Object(m.h)(this.props.branchLike)?Object(v.b)({project:this.props.component.key,pullRequest:this.props.branchLike.key}):Object(v.a)({branch:this.props.branchLike.name,project:this.props.component.key})).then(()=>{this.mounted&&(this.setState({loading:!1}),this.props.onDelete())},()=>{this.mounted&&this.setState({loading:!1})})}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{branchLike:e}=this.props,t=Object(r.translate)(Object(m.h)(e)?"project_branch_pull_request.pull_request.delete":"project_branch_pull_request.branch.delete");return a.createElement(C.a,{contentLabel:t,onRequestClose:this.props.onClose},a.createElement("header",{className:"modal-head"},a.createElement("h2",null,t)),a.createElement("form",{onSubmit:this.handleSubmit},a.createElement("div",{className:"modal-body"},Object(r.translateWithParameters)(Object(m.h)(e)?"project_branch_pull_request.pull_request.delete.are_you_sure":"project_branch_pull_request.branch.delete.are_you_sure",Object(m.b)(e))),a.createElement("footer",{className:"modal-foot"},this.state.loading&&a.createElement("i",{className:"spinner spacer-right"}),a.createElement(L.SubmitButton,{className:"button-red",disabled:this.state.loading},Object(r.translate)("delete")),a.createElement(L.ResetButtonLink,{onClick:this.props.onClose},Object(r.translate)("cancel")))))}}var B,w=n(340),D=n.n(w),x=n(346),A=n.n(x);class F extends a.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1},this.handleSubmit=e=>{e.preventDefault(),this.state.name&&(this.setState({loading:!0}),Object(v.f)(this.props.component.key,this.state.name).then(()=>{this.mounted&&(this.setState({loading:!1}),this.props.onRename())},()=>{this.mounted&&this.setState({loading:!1})}))},this.handleNameChange=e=>{this.setState({name:e.currentTarget.value})}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{branch:e}=this.props,t=Object(r.translate)("project_branch_pull_request.branch.rename"),n=this.state.loading||!this.state.name||this.state.name===e.name;return a.createElement(C.a,{contentLabel:t,onRequestClose:this.props.onClose,size:"small"},a.createElement("header",{className:"modal-head"},a.createElement("h2",null,t)),a.createElement("form",{onSubmit:this.handleSubmit},a.createElement("div",{className:"modal-body"},a.createElement(A.a,{className:"modal-field"}),a.createElement("div",{className:"modal-field"},a.createElement("label",{htmlFor:"rename-branch-name"},Object(r.translate)("new_name"),a.createElement(D.a,null)),a.createElement("input",{autoFocus:!0,id:"rename-branch-name",maxLength:100,name:"name",onChange:this.handleNameChange,required:!0,size:50,type:"text",value:void 0!==this.state.name?this.state.name:e.name}))),a.createElement("footer",{className:"modal-foot"},this.state.loading&&a.createElement("i",{className:"spinner spacer-right"}),a.createElement(L.SubmitButton,{disabled:n},Object(r.translate)("rename")),a.createElement(L.ResetButtonLink,{onClick:this.props.onClose},Object(r.translate)("cancel")))))}}!function(e){e[e.Branch=0]="Branch",e[e.PullRequest=1]="PullRequest"}(B||(B={}));const T=[{key:B.Branch,label:a.createElement(a.Fragment,null,a.createElement(o.a,null),a.createElement("span",{className:"spacer-left"},Object(r.translate)("project_branch_pull_request.tabs.branches")))},{key:B.PullRequest,label:a.createElement(a.Fragment,null,a.createElement(u.a,null),a.createElement("span",{className:"spacer-left"},Object(r.translate)("project_branch_pull_request.tabs.pull_requests")))}];class M extends a.PureComponent{constructor(){super(...arguments),this.state={currentTab:B.Branch},this.onTabSelect=e=>{this.setState({currentTab:e})},this.onDeleteBranchLike=e=>this.setState({deleting:e}),this.onRenameBranchLike=e=>this.setState({renaming:e}),this.onClose=()=>this.setState({deleting:void 0,renaming:void 0}),this.onModalActionFulfilled=()=>{this.onClose(),this.props.onBranchesChange()}}render(){const{branchLikes:e,component:t}=this.props,{currentTab:n,deleting:s,renaming:l}=this.state,o=n===B.Branch,i=o?Object(m.j)(e.filter(m.f)):Object(m.k)(e.filter(m.h)),u=Object(r.translate)(o?"project_branch_pull_request.table.branch":"project_branch_pull_request.table.pull_request");return a.createElement(a.Fragment,null,a.createElement(c.a,{className:"branch-like-tabs",onSelect:this.onTabSelect,selected:n,tabs:T}),a.createElement(q,{branchLikes:i,component:t,displayPurgeSetting:o,onDelete:this.onDeleteBranchLike,onRename:this.onRenameBranchLike,title:u}),s&&a.createElement(R,{branchLike:s,component:t,onClose:this.onClose,onDelete:this.onModalActionFulfilled}),l&&Object(m.g)(l)&&a.createElement(F,{branch:l,component:t,onClose:this.onClose,onRename:this.onModalActionFulfilled}))}}var I=n(325),J=n(452),U=n(327),W=n(568),z=n(316),V=n(318),Y=n(320);var G=a.memo((function(e){const{branchAndPullRequestLifeTimeInDays:t,canAdmin:n,loading:s}=e;return a.createElement(y.a,{loading:s},t&&a.createElement("p",{className:"page-description"},a.createElement(z.FormattedMessage,{defaultMessage:Object(r.translate)("project_branch_pull_request.lifetime_information"),id:"project_branch_pull_request.lifetime_information",values:{days:Object(Y.formatMeasure)(t,"INT")}}),n&&a.createElement(z.FormattedMessage,{defaultMessage:Object(r.translate)("project_branch_pull_request.lifetime_information.admin"),id:"project_branch_pull_request.lifetime_information.admin",values:{settings:a.createElement(V.c,{to:"/admin/settings"},Object(r.translate)("settings.page"))}})))}));class H extends a.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!0}}componentDidMount(){this.mounted=!0,this.fetchBranchAndPullRequestLifetimeSetting()}componentWillUnmount(){this.mounted=!1}fetchBranchAndPullRequestLifetimeSetting(){Object(J.e)({keys:W.a.DaysBeforeDeletingInactiveBranchesAndPRs}).then(e=>{this.mounted&&this.setState({loading:!1,branchAndPullRequestLifeTimeInDays:e.length>0?e[0].value:void 0})},()=>{this.mounted&&this.setState({loading:!1})})}render(){const{canAdmin:e}=this.props,{branchAndPullRequestLifeTimeInDays:t,loading:n}=this.state;return a.createElement(G,{branchAndPullRequestLifeTimeInDays:t,canAdmin:e,loading:n})}}var K=Object(I.b)(e=>({canAdmin:Object(U.getAppState)(e).canAdmin}))(H);function Q(e){const{branchLikes:t,component:n,onBranchesChange:s}=e;return a.createElement("div",{className:"page page-limited",id:"project-branch-like"},a.createElement("header",{className:"page-header"},a.createElement("h1",null,Object(r.translate)("project_branch_pull_request.page")),a.createElement(K,null)),a.createElement(M,{branchLikes:t,component:n,onBranchesChange:s}))}t.default=a.memo(Q)},452:function(e,t,n){"use strict";n.d(t,"d",(function(){return o})),n.d(t,"e",(function(){return i})),n.d(t,"h",(function(){return u})),n.d(t,"i",(function(){return m})),n.d(t,"f",(function(){return h})),n.d(t,"g",(function(){return p})),n.d(t,"a",(function(){return d})),n.d(t,"c",(function(){return b})),n.d(t,"b",(function(){return g}));var a=n(437),r=n.n(a),s=n(9),c=n(324),l=n(432);function o(e){return Object(s.getJSON)("/api/settings/list_definitions",{component:e}).then(e=>e.definitions,c.a)}function i(e){return Object(s.getJSON)("/api/settings/values",e).then(e=>e.settings)}function u(e,t,n){const{key:a}=e,c={key:a,component:n};return Object(l.k)(e)&&e.multiValues?c.values=t:"PROPERTY_SET"===e.type?c.fieldValues=t.map(e=>r()(e,e=>null==e)).map(JSON.stringify):c.value=t,Object(s.post)("/api/settings/set",c)}function m(e){return Object(s.post)("/api/settings/set",e).catch(c.a)}function h(e){return Object(s.post)("/api/settings/reset",e)}function p(e,t,n){return Object(s.post)("/api/emails/send",{to:e,subject:t,message:n})}function d(){return Object(s.getJSON)("/api/settings/check_secret_key").catch(c.a)}function b(){return Object(s.postJSON)("/api/settings/generate_secret_key").catch(c.a)}function g(e){return Object(s.postJSON)("/api/settings/encrypt",{value:e}).catch(c.a)}},568:function(e,t,n){"use strict";var a;n.d(t,"a",(function(){return a})),function(e){e.DaysBeforeDeletingInactiveBranchesAndPRs="sonar.dbcleaner.daysBeforeDeletingInactiveBranchesAndPRs",e.DefaultProjectVisibility="projects.default.visibility",e.ServerBaseUrl="sonar.core.serverBaseURL",e.PluginRiskConsent="sonar.plugins.risk.consent"}(a||(a={}))},595:function(e,t,n){"use strict";n.d(t,"a",(function(){return u}));var a=n(2),r=n(407),s=n.n(r),c=n(528),l=n.n(c),o=n(328);function i(e,t){if(null==e)return{};var n,a,r=function(e,t){if(null==e)return{};var n,a,r={},s=Object.keys(e);for(a=0;a<s.length;a++)n=s[a],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);for(a=0;a<s.length;a++)n=s[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}function u(e){let{branchLike:t}=e,n=i(e,["branchLike"]);return Object(o.h)(t)?a.createElement(l.a,Object.assign({},n)):a.createElement(s.a,Object.assign({},n))}},624:function(e,t,n){"use strict";n.d(t,"d",(function(){return s})),n.d(t,"e",(function(){return c})),n.d(t,"a",(function(){return l})),n.d(t,"b",(function(){return o})),n.d(t,"f",(function(){return i})),n.d(t,"c",(function(){return u}));var a=n(9),r=n(324);function s(e){return Object(a.getJSON)("/api/project_branches/list",{project:e}).then(e=>e.branches,r.a)}function c(e){return Object(a.getJSON)("/api/project_pull_requests/list",{project:e}).then(e=>e.pullRequests,r.a)}function l(e){return Object(a.post)("/api/project_branches/delete",e).catch(r.a)}function o(e){return Object(a.post)("/api/project_pull_requests/delete",e).catch(r.a)}function i(e,t){return Object(a.post)("/api/project_branches/rename",{project:e,name:t}).catch(r.a)}function u(e,t,n){return Object(a.post)("/api/project_branches/set_automatic_deletion_protection",{project:e,branch:t,value:n}).catch(r.a)}},776:function(e,t,n){"use strict";var a=n(2),r=n(325),s=n(386),c=n.n(s),l=n(327);t.a=Object(r.b)((e,t)=>{const{branchLike:n,component:a}=t,{status:r}=Object(l.getBranchStatusByBranchLike)(e,a,n);return{status:r}})((function({status:e}){return e?a.createElement(c.a,{level:e,small:!0}):null}))}}]);
//# sourceMappingURL=331.m.a7995846.chunk.js.map
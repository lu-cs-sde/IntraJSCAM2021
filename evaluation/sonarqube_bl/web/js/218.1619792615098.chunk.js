(window.webpackJsonp=window.webpackJsonp||[]).push([[218],{386:function(e,a,r){e.exports=function(){"use strict";return[{locale:"sr",pluralRuleFunction:function(e,a){var r=String(e).split("."),t=r[0],o=r[1]||"",i=!r[1],s=t.slice(-1),n=t.slice(-2),l=o.slice(-1),p=o.slice(-2);return a?"other":i&&1==s&&11!=n||1==l&&11!=p?"one":i&&s>=2&&s<=4&&(n<12||n>14)||l>=2&&l<=4&&(p<12||p>14)?"few":"other"},fields:{year:{displayName:"година",relative:{0:"ове године",1:"следеће године","-1":"прошле године"},relativeTime:{future:{one:"за {0} годину",few:"за {0} године",other:"за {0} година"},past:{one:"пре {0} године",few:"пре {0} године",other:"пре {0} година"}}},"year-short":{displayName:"год.",relative:{0:"ове год.",1:"следеће год.","-1":"прошле год."},relativeTime:{future:{one:"за {0} год.",few:"за {0} год.",other:"за {0} год."},past:{one:"пре {0} год.",few:"пре {0} год.",other:"пре {0} год."}}},month:{displayName:"месец",relative:{0:"овог месеца",1:"следећег месеца","-1":"прошлог месеца"},relativeTime:{future:{one:"за {0} месец",few:"за {0} месеца",other:"за {0} месеци"},past:{one:"пре {0} месеца",few:"пре {0} месеца",other:"пре {0} месеци"}}},"month-short":{displayName:"мес.",relative:{0:"овог мес.",1:"следећег мес.","-1":"прошлог мес."},relativeTime:{future:{one:"за {0} мес.",few:"за {0} мес.",other:"за {0} мес."},past:{one:"пре {0} мес.",few:"пре {0} мес.",other:"пре {0} мес."}}},day:{displayName:"дан",relative:{0:"данас",1:"сутра",2:"прекосутра","-2":"прекјуче","-1":"јуче"},relativeTime:{future:{one:"за {0} дан",few:"за {0} дана",other:"за {0} дана"},past:{one:"пре {0} дана",few:"пре {0} дана",other:"пре {0} дана"}}},"day-short":{displayName:"д.",relative:{0:"данас",1:"сутра",2:"прекосутра","-2":"прекјуче","-1":"јуче"},relativeTime:{future:{one:"за {0} д.",few:"за {0} д.",other:"за {0} д."},past:{one:"пре {0} д.",few:"пре {0} д.",other:"пре {0} д."}}},hour:{displayName:"сат",relative:{0:"овог сата"},relativeTime:{future:{one:"за {0} сат",few:"за {0} сата",other:"за {0} сати"},past:{one:"пре {0} сата",few:"пре {0} сата",other:"пре {0} сати"}}},"hour-short":{displayName:"ч.",relative:{0:"овог сата"},relativeTime:{future:{one:"за {0} ч.",few:"за {0} ч.",other:"за {0} ч."},past:{one:"пре {0} ч.",few:"пре {0} ч.",other:"пре {0} ч."}}},minute:{displayName:"минут",relative:{0:"овог минута"},relativeTime:{future:{one:"за {0} минут",few:"за {0} минута",other:"за {0} минута"},past:{one:"пре {0} минута",few:"пре {0} минута",other:"пре {0} минута"}}},"minute-short":{displayName:"мин.",relative:{0:"овог минута"},relativeTime:{future:{one:"за {0} мин.",few:"за {0} мин.",other:"за {0} мин."},past:{one:"пре {0} мин.",few:"пре {0} мин.",other:"пре {0} мин."}}},second:{displayName:"секунд",relative:{0:"сада"},relativeTime:{future:{one:"за {0} секунду",few:"за {0} секунде",other:"за {0} секунди"},past:{one:"пре {0} секунде",few:"пре {0} секунде",other:"пре {0} секунди"}}},"second-short":{displayName:"сек.",relative:{0:"сада"},relativeTime:{future:{one:"за {0} сек.",few:"за {0} сек.",other:"за {0} сек."},past:{one:"пре {0} сек.",few:"пре {0} сек.",other:"пре {0} сек."}}}}},{locale:"sr-Cyrl",parentLocale:"sr"},{locale:"sr-Cyrl-BA",parentLocale:"sr-Cyrl"},{locale:"sr-Cyrl-ME",parentLocale:"sr-Cyrl"},{locale:"sr-Cyrl-XK",parentLocale:"sr-Cyrl"},{locale:"sr-Latn",pluralRuleFunction:function(e,a){return"other"},fields:{year:{displayName:"godina",relative:{0:"ove godine",1:"sledeće godine","-1":"prošle godine"},relativeTime:{future:{one:"za {0} godinu",few:"za {0} godine",other:"za {0} godina"},past:{one:"pre {0} godine",few:"pre {0} godine",other:"pre {0} godina"}}},"year-short":{displayName:"god.",relative:{0:"ove god.",1:"sledeće god.","-1":"prošle god."},relativeTime:{future:{one:"za {0} god.",few:"za {0} god.",other:"za {0} god."},past:{one:"pre {0} god.",few:"pre {0} god.",other:"pre {0} god."}}},month:{displayName:"mesec",relative:{0:"ovog meseca",1:"sledećeg meseca","-1":"prošlog meseca"},relativeTime:{future:{one:"za {0} mesec",few:"za {0} meseca",other:"za {0} meseci"},past:{one:"pre {0} meseca",few:"pre {0} meseca",other:"pre {0} meseci"}}},"month-short":{displayName:"mes.",relative:{0:"ovog mes.",1:"sledećeg mes.","-1":"prošlog mes."},relativeTime:{future:{one:"za {0} mes.",few:"za {0} mes.",other:"za {0} mes."},past:{one:"pre {0} mes.",few:"pre {0} mes.",other:"pre {0} mes."}}},day:{displayName:"dan",relative:{0:"danas",1:"sutra",2:"prekosutra","-2":"prekjuče","-1":"juče"},relativeTime:{future:{one:"za {0} dan",few:"za {0} dana",other:"za {0} dana"},past:{one:"pre {0} dana",few:"pre {0} dana",other:"pre {0} dana"}}},"day-short":{displayName:"d.",relative:{0:"danas",1:"sutra",2:"prekosutra","-2":"prekjuče","-1":"juče"},relativeTime:{future:{one:"za {0} d.",few:"za {0} d.",other:"za {0} d."},past:{one:"pre {0} d.",few:"pre {0} d.",other:"pre {0} d."}}},hour:{displayName:"sat",relative:{0:"ovog sata"},relativeTime:{future:{one:"za {0} sat",few:"za {0} sata",other:"za {0} sati"},past:{one:"pre {0} sata",few:"pre {0} sata",other:"pre {0} sati"}}},"hour-short":{displayName:"č.",relative:{0:"ovog sata"},relativeTime:{future:{one:"za {0} č.",few:"za {0} č.",other:"za {0} č."},past:{one:"pre {0} č.",few:"pre {0} č.",other:"pre {0} č."}}},minute:{displayName:"minut",relative:{0:"ovog minuta"},relativeTime:{future:{one:"za {0} minut",few:"za {0} minuta",other:"za {0} minuta"},past:{one:"pre {0} minuta",few:"pre {0} minuta",other:"pre {0} minuta"}}},"minute-short":{displayName:"min.",relative:{0:"ovog minuta"},relativeTime:{future:{one:"za {0} min.",few:"za {0} min.",other:"za {0} min."},past:{one:"pre {0} min.",few:"pre {0} min.",other:"pre {0} min."}}},second:{displayName:"sekund",relative:{0:"sada"},relativeTime:{future:{one:"za {0} sekundu",few:"za {0} sekunde",other:"za {0} sekundi"},past:{one:"pre {0} sekunde",few:"pre {0} sekunde",other:"pre {0} sekundi"}}},"second-short":{displayName:"sek.",relative:{0:"sada"},relativeTime:{future:{one:"za {0} sek.",few:"za {0} sek.",other:"za {0} sek."},past:{one:"pre {0} sek.",few:"pre {0} sek.",other:"pre {0} sek."}}}}},{locale:"sr-Latn-BA",parentLocale:"sr-Latn"},{locale:"sr-Latn-ME",parentLocale:"sr-Latn"},{locale:"sr-Latn-XK",parentLocale:"sr-Latn"}]}()}}]);
//# sourceMappingURL=218.1619792615098.chunk.js.map
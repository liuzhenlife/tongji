/**
 * 统计代码
 * Created by liuzhen on 2017/9/7.
 */
var liuZhenTongJiCaller, liuZhenTongJiTag;
liuZhenTongJiCaller = {
    fetch: function (a, b) {
        var c = "BusuanziCallback_" + Math.floor(1099511627776 * Math.random());
        window[c] = this.evalCall(b);
        a = a.replace("=BusuanziCallback", "=" + c);

        var title = document.getElementsByTagName("title")[0].text;
        a += "&pageTitle=" + title;

        var meta = document.getElementsByTagName('meta');
        var metaDescription = '';
        var metaKeyword = '';
        for(i in meta){
            if(typeof meta[i].name!="undefined"&&meta[i].name.toLowerCase()=="description"){
                metaDescription = meta[i].content;
            }
            if(typeof meta[i].name!="undefined"&&meta[i].name.toLowerCase()=="keywords"){
                metaKeyword = meta[i].content;
            }
        }
        a += "&metaDescription=" + metaDescription;
        a += "&metaKeyword=" + metaKeyword;

        var screenWidth = window.screen.width;
        a += "&screenWidth=" + screenWidth;
        var screenHeight = window.screen.height;
        a += "&screenHeight=" + screenHeight;
        var colorDepth = window.screen.colorDepth;
        a += "&colorDepth=" + colorDepth;
        var cookieEnabled = 0;
        if (navigator.cookieEnabled) {
            cookieEnabled = 1;
        }
        a += "&cookieEnabled=" + cookieEnabled;
        var flash = flashChecker();
        var fashEnabled = flash.f;
        a += "&fashEnabled=" + fashEnabled;
        var flashVersion = flash.v;
        a += "&flashVersion=" + flashVersion;

        scriptTag = document.createElement("SCRIPT");
        scriptTag.type = "text/javascript";
        scriptTag.defer = !0;
        scriptTag.src = a;
        document.getElementsByTagName("HEAD")[0].appendChild(scriptTag);
    },
    evalCall: function (a) {
        return function (b) {
            ready(function () {
                try {
                    a(b),
                        scriptTag.parentElement.removeChild(scriptTag)
                } catch (c) {
                    liuZhenTongJiTag.hides()
                }
            })
        }
    }
},
    liuZhenTongJiCaller.fetch("http://localhost:8090/tongji?jsonpCallback=BusuanziCallback",
        function (a) {
            liuZhenTongJiTag.texts(a),
                liuZhenTongJiTag.shows()
        }),
    liuZhenTongJiTag = {
        liuZhenTongJis: ["site_pv", "page_pv", "site_uv"],
        texts: function (a) {
            this.liuZhenTongJis.map(function (b) {
                var c = document.getElementById("busuanzi_value_" + b);
                c && (c.innerHTML = a[b])
            })
        },
        hides: function () {
            this.liuZhenTongJis.map(function (a) {
                var b = document.getElementById("busuanzi_container_" + a);
                b && (b.style.display = "none")
            })
        },
        shows: function () {
            this.liuZhenTongJis.map(function (a) {
                var b = document.getElementById("busuanzi_container_" + a);
                b && (b.style.display = "inline")
            })
        }
    };

function flashChecker() {
    var hasFlash = 0; //是否安装了flash
    var flashVersion = 0; //flash版本
    if (document.all) {
        var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
        if (swf) {
            hasFlash = 1;
            VSwf = swf.GetVariable("$version");
            flashVersion = parseInt(VSwf.split(" ")[1].split(",")[0]);
        }
    } else {
        if (navigator.plugins && navigator.plugins.length > 0) {
            var swf = navigator.plugins["Shockwave Flash"];
            if (swf) {
                hasFlash = 1;
                var words = swf.description.split(" ");
                for (var i = 0; i < words.length; ++i) {
                    if (isNaN(parseInt(words[i]))) continue;
                    flashVersion = parseInt(words[i]);
                }
            }
        }
    }
    return {f: hasFlash, v: flashVersion};
}
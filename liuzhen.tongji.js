/**
 * 统计代码
 * Created by liuzhen on 2017/9/7.
 */
var liuZhenTongJiCaller, liuZhenTongJiTag;
!
    function () {
        var c, d, e, a = !1,
            b = [];
        ready = function (c) {
            return a || "interactive" === document.readyState || "complete" === document.readyState ? c.call(document) : b.push(function () {
                return c.call(this)
            }),
                this
        },
            d = function () {
                for (var a = 0,
                         c = b.length; c > a; a++) b[a].apply(document);
                b = []
            },
            e = function () {
                a || (a = !0, d.call(window), document.removeEventListener ? document.removeEventListener("DOMContentLoaded", e, !1) : document.attachEvent && (document.detachEvent("onreadystatechange", e), window == window.top && (clearInterval(c), c = null)))
            },
            document.addEventListener ? document.addEventListener("DOMContentLoaded", e, !1) : document.attachEvent && (document.attachEvent("onreadystatechange",
                    function () {
                        / loaded | complete /.test(document.readyState) && e()
                    }), window == window.top && (c = setInterval(function () {
                        try {
                            a || document.documentElement.doScroll("left")
                        } catch (b) {
                            return
                        }
                        e()
                    },
                    5)))
    }();

liuZhenTongJiCaller = {
    fetch: function (a, b) {
        var c = "liuzhenCallback_" + Math.floor(1099511627776 * Math.random());
        window[c] = this.evalCall(b);
        a = a.replace("=liuzhenCallback", "=" + c);

        var params = "";
        var referer = document.referrer;
        params += "&referer=" + referer;

        var title = document.getElementsByTagName("title")[0].text;
        params += "&pageTitle=" + title;

        var meta = document.getElementsByTagName('meta');
        var metaDescription = '';
        var metaKeyword = '';
        for (i in meta) {
            if (typeof meta[i].name != "undefined" && meta[i].name.toLowerCase() == "description") {
                metaDescription = meta[i].content;
            }
            if (typeof meta[i].name != "undefined" && meta[i].name.toLowerCase() == "keywords") {
                metaKeyword = meta[i].content;
            }
        }
        params += "&metaDescription=" + metaDescription;
        params += "&metaKeyword=" + metaKeyword;

        var screenWidth = window.screen.width;
        params += "&screenWidth=" + screenWidth;
        var screenHeight = window.screen.height;
        params += "&screenHeight=" + screenHeight;
        var colorDepth = window.screen.colorDepth;
        params += "&colorDepth=" + colorDepth;
        var cookieEnabled = 0;
        if (navigator.cookieEnabled) {
            cookieEnabled = 1;
        }
        params += "&cookieEnabled=" + cookieEnabled;
        var flash = flashChecker();
        var fashEnabled = flash.f;
        params += "&fashEnabled=" + fashEnabled;
        var flashVersion = flash.v;
        params += "&flashVersion=" + flashVersion;

        params = encodeURI(params);

        scriptTag = document.createElement("SCRIPT");
        scriptTag.type = "text/javascript";
        scriptTag.defer = !0;
        scriptTag.src = a + params;
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
    liuZhenTongJiCaller.fetch("http://tongji.itliuzhen.com/tongji/?jsonpCallback=liuzhenCallback",
        function (a) {
            liuZhenTongJiTag.texts(a),
                liuZhenTongJiTag.shows()
        }),
    liuZhenTongJiTag = {
        liuZhenTongJis: ["site_pv", "page_pv", "site_uv"],
        texts: function (a) {
            this.liuZhenTongJis.map(function (b) {
                var c = document.getElementById("liuzhen_value_" + b);
                c && (c.innerHTML = a[b])
            })
        },
        hides: function () {
            this.liuZhenTongJis.map(function (a) {
                var b = document.getElementById("liuzhen_container_" + a);
                b && (b.style.display = "none")
            })
        },
        shows: function () {
            this.liuZhenTongJis.map(function (a) {
                var b = document.getElementById("liuzhen_container_" + a);
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
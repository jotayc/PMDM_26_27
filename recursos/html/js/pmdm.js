(function(){
  "use strict";

  /* ---------- Resaltado de código (XML y Java) ---------- */
  function esc(s){ return s.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;"); }
  function hlXml(src){
    return src.replace(/(&lt;\?[\s\S]*?\?&gt;)|(&lt;\/?)([\w.:-]+)|([\w-]+)(:)([\w-]+)(=)|([\w-]+)(=)|("[^"]*")|(\/?&gt;)/g,
      function(m, pi, open, tag, pre, colon, attr, eq, attr2, eq2, str, close){
        if(pi) return '<span class="tk-com">' + pi + '</span>';
        if(open) return '<span class="tk-tag">' + open + tag + '</span>';
        if(pre) return '<span class="tk-ns">' + pre + '</span>' + colon + '<span class="tk-attr">' + attr + '</span>' + eq;
        if(attr2) return '<span class="tk-attr">' + attr2 + '</span>' + eq2;
        if(str) return '<span class="tk-str">' + str + '</span>';
        if(close) return '<span class="tk-tag">' + close + '</span>';
        return m;
      });
  }
  function hlJava(src){
    return src.replace(/("[^"]*")|(\/\/.*)|(@\w+)|\b(package|import|public|protected|private|class|extends|implements|void|return|new|super|this|static|final|null|true|false|if|else)\b/g,
      function(m, str, com, ann, key){
        if(str) return '<span class="tk-str">' + str + '</span>';
        if(com) return '<span class="tk-com">' + com + '</span>';
        if(ann) return '<span class="tk-ann">' + ann + '</span>';
        if(key) return '<span class="tk-key">' + key + '</span>';
        return m;
      });
  }
  document.querySelectorAll("code.lang-xml").forEach(function(c){ c.innerHTML = hlXml(esc(c.textContent)); });
  document.querySelectorAll("code.lang-java").forEach(function(c){ c.innerHTML = hlJava(esc(c.textContent)); });

  /* ---------- Índice lateral: scroll-spy + móvil ---------- */
  var navLinks = Array.prototype.slice.call(document.querySelectorAll(".navlist a[data-nav]"));
  var targets = navLinks.map(function(l){ return document.getElementById(l.getAttribute("data-target")); });

  navLinks.forEach(function(link){
    link.addEventListener("click", function(ev){
      ev.preventDefault();
      closeSidebar();
      var t = document.getElementById(link.getAttribute("data-target"));
      if(t) window.scrollTo({top: t.getBoundingClientRect().top + window.pageYOffset - 12, behavior: "smooth"});
    });
  });

  function updateActive(){
    var current = 0;
    targets.forEach(function(t, i){ if(t && t.getBoundingClientRect().top < 140) current = i; });
    navLinks.forEach(function(l, i){ l.classList.toggle("active", i === current); });
  }
  window.addEventListener("scroll", updateActive, {passive: true});
  updateActive();

  var sidebar = document.getElementById("sidebar");
  var scrim = document.getElementById("scrim");
  function openSidebar(){ sidebar.classList.add("open"); scrim.classList.add("show"); }
  function closeSidebar(){ sidebar.classList.remove("open"); scrim.classList.remove("show"); }
  document.getElementById("menuToggle").addEventListener("click", openSidebar);
  scrim.addEventListener("click", closeSidebar);
})();

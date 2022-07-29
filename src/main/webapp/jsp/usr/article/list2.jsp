<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<script>
    let Articles_lastId = 0;
    function Article_loadMore() {
        fetch(`/usr/article/getArticles/free?fromId=${Articles_lastId}`)
            .then(data => data.json())
            .then(responseData => {
               for(const key in responseData.data) {
                   const article = responseData.data[key];
                   console.log(article);
                   const html = `
                        <li>\${article.title}</li>
                   `;
                   $('.articles').append(html);

               }
            });

    }
</script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트(auto ver.)</h1>

        <ul class="articles mt-5">
<%--            이 부분에 자바스크립트를 이용해서 자동으로 채워준다--%>
        </ul>
        <hr>

        <button class="btn btn-sm" onClick="Article_loadMore();">불러오기</button>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>

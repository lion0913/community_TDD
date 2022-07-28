import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.exam.article.ArticleController;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Util;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void assertThatTest() {
        int rs = 10+30;
        assertThat(rs).isEqualTo(40);
    }

    @Test
    void objectMapperTest_objToJsonStr() {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");

        String jsonStr = Util.json.toJson(articleDto, "");
        System.out.println(jsonStr);
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim());
    }

    @Test
    void objectMapperTest_jsonStrToObj() {
        //json string으로 만드는 과정
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");
        String jsonStr = Util.json.toJson(articleDto, "");

        ArticleDto articleDtoFromJson = Util.json.toObj(jsonStr, ArticleDto.class, null);

        assertThat(articleDto).isEqualTo(articleDtoFromJson);

    }

    @Test
    void objectMapperTest_listToJson() {
        List<ArticleDto> articleDtoList = new ArrayList<ArticleDto>();
        for(int i = 0; i < 5; i++) {
            ArticleDto articleDto = new ArticleDto(i, "제목", "내용");
            articleDtoList.add(articleDto);
        }

        String jsonStr = Util.json.toJson(articleDtoList, "");
        System.out.println(jsonStr.toString());

    }

    @Test
    void objectMapperTest_MapToJson() {
        Map<Integer, ArticleDto> map = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            ArticleDto articleDto = new ArticleDto(i, "제목", "내용");
            map.put(i, articleDto);
        }
        String mapStr = Util.json.toJson(map, "");
        System.out.println("mapToJson");
        System.out.println(mapStr.toString());
    }

    @Test
    void objectMapperTest_jsonToObjectList() {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        articleDtoList.add(new ArticleDto(1, "제목1", "내용1"));
        articleDtoList.add(new ArticleDto(2, "제목2", "내용2"));

        String origin = Util.json.toJson(articleDtoList, "");
        List<ArticleDto> articleDtoList1 = Util.json.toObj(origin, new TypeReference<>() {}, null);
        assertThat(articleDtoList).isEqualTo(articleDtoList1);

    }

    @Test
    void ObjectMapper__jsonStrToArticleDtoMap() {
        Map<String, ArticleDto> articleDtoMap = new HashMap<>();
        articleDtoMap.put("가장오래된", new ArticleDto(1, "제목1", "내용1"));
        articleDtoMap.put("최신", new ArticleDto(2, "제목2", "내용2"));
        String jsonStr = Util.json.toJson(articleDtoMap, "");

        Map<String, ArticleDto> articleDtoMapFromJson = Util.json.toObj(jsonStr, new TypeReference<>() {}, null);

        assertThat(articleDtoMapFromJson).isEqualTo(articleDtoMap);
    }

}


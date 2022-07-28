import com.fasterxml.jackson.core.JsonProcessingException;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Util;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;

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


}


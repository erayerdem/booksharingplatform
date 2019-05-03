package book.bookplatform;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Succces Request")
    public void ccc() throws Exception {
        MvcResult authorization = this.mockMvc.perform
                (get("/api/books").header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW1ldGVyYXllcmRtQGdtYWlsLmNvbSIsImV4cCI6MTU1NjIwNTMxNH0.hKDgr_8kE8PWS4OORsBiQPejlcCrGL49QtM068rvLRrNLwrpONnUUlCgB_YRuPEwbDJn6BLieDffIjUMMvqYew"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"bookname\": \"ahmet\",\n" +
                        "    \"author\": \"eray\",\n" +
                        "    \"page\": 100,\n" +
                        "    \"coverphoto\": \"xx\",\n" +
                        "    \"summary\": \"ozet\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"bookname\": \"samet\",\n" +
                        "    \"author\": \"eray\",\n" +
                        "    \"page\": 100,\n" +
                        "    \"coverphoto\": \"xx\",\n" +
                        "    \"summary\": \"ozet\"\n" +
                        "  }\n" +
                        "]"))
                .andReturn();
        MockHttpServletResponse response = authorization.getResponse();
        String contentAsString = response.getContentAsString();
        assertThat(contentAsString).isNotNull();
        assertThat(contentAsString).isNotBlank();
    }
    @Test
    @DisplayName("unsucces request Throw Exception 400 ")
    public  void qqq(){

    }
}

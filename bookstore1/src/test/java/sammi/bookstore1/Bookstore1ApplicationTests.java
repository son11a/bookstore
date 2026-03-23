package sammi.bookstore1;

  import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sammi.bookstore1.domain.web.BookController;

@SpringBootTest
class Bookstore1ApplicationTests {

	@Autowired
  	private BookController controller;

	@Test
    public void contexLoads() throws Exception {
      assertThat(controller).isNotNull();
    }
	
}

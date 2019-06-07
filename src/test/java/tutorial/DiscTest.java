package tutorial;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscTest {

    @Test
    public void checkDiscSize() {
        // given
        Disc disc = new Disc(5);

        // when
        int discSize = disc.getSize();

        // then
        assertThat(discSize).isEqualTo(5);
    }

}

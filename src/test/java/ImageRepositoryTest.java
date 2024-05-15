import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mycorp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ImageRepositoryTest {
    @Autowired
    private final ImageRepository imageRepository = new ImageRepository();

    @Test
    public void saveTest() throws IOException {
        //String imagePath = "src/main/resources/testImage.jpg";
        //BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        //String imageBase64 = getImageBase64String(bufferedImage);

        //Image image = new Image("myImage", imageBase64, new User());
        //Image savedImage = imageRepository.getEntity(image.getId()).get();

        //Assertions.assertEquals(image, savedImage);
    }

    private String getImageBase64String(BufferedImage image) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "jpg", baos);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

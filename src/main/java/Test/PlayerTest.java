package Test;
import com.example.fishinggamethegame.Player;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {

    @Test
    public void testIncrementRodLevel() {
        Assert.assertEquals(0, Player.getRodLevel());
        Player.incrementRodLevel();
        Assert.assertEquals(1, Player.getRodLevel());
    }

    @Test
    public void testIncrementBaitLevel() {
        Assert.assertEquals(0, Player.getBaitLevel());
        Player.incrementBaitLevel();
        Assert.assertEquals(1, Player.getBaitLevel());
    }

    @Test
    public void testSetFishCount() {
        Assert.assertEquals(0, Player.getFishCount());
        Player.setFishCount(10);
        Assert.assertEquals(10, Player.getFishCount());
    }

    @Test
    public void testSetCoinCount() {
        Assert.assertEquals(0, Player.getCoinCount());
        Player.setCoinCount(5);
        Assert.assertEquals(5, Player.getCoinCount());
    }

    @Test
    public void testSetCurrentScore() {
        Assert.assertEquals(0, Player.getCurrentScore());
        Player.setCurrentScore(40);
        Assert.assertEquals(40, Player.getCurrentScore());
    }

    @Test
    public void testUnlockOcean() {
        Assert.assertFalse(Player.isOceanUnlocked());
        Player.unlockOcean();
        Assert.assertTrue(Player.isOceanUnlocked());
    }

    @Test
    public void testSetLastScene() {
        Assert.assertNull(Player.getLastScene());
        Player.setLastScene("Controller.fxml");
        Assert.assertEquals("Controller.fxml", Player.getLastScene());
    }

    @Test
    public void testDecrementThreshold() {
        Assert.assertEquals(120, Player.getCatchThreshold());
        Player.decrementThreshold();
        Assert.assertEquals(115, Player.getCatchThreshold());
    }

    @Test
    public void testIncreaseBaitStrength() {
        Assert.assertEquals(150, Player.getMaxBaitStrength());
        Player.increaseBaitStrength();
        Assert.assertEquals(140, Player.getMaxBaitStrength());
    }
}

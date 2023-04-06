package Test;
import com.example.fishinggamethegame.Player;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {
    @Test
    public void testGetRodLevel() {
        Assert.assertEquals(0, Player.getRodLevel());
    }

    @Test
    public void testIncrementRodLevel() {
        Player.incrementRodLevel();
        Assert.assertEquals(1, Player.getRodLevel());
    }

    @Test
    public void testGetBaitLevel() {
        Assert.assertEquals(0, Player.getBaitLevel());
    }

    @Test
    public void testIncrementBaitLevel() {
        Player.incrementBaitLevel();
        Assert.assertEquals(1, Player.getBaitLevel());
    }

    @Test
    public void testGetFishCount() {
        Assert.assertEquals(0, Player.getFishCount());
    }

    @Test
    public void testSetFishCount() {
        Player.setFishCount(10);
        Assert.assertEquals(10, Player.getFishCount());
    }

    @Test
    public void testGetCoinCount() {
        Assert.assertEquals(0, Player.getCoinCount());
    }

    @Test
    public void testSetCoinCount() {
        Player.setCoinCount(5);
        Assert.assertEquals(5, Player.getCoinCount());
    }

    @Test
    public void testGetCurrentScore() {
        Assert.assertEquals(0, Player.getCurrentScore());
    }

    @Test
    public void testSetCurrentScore() {
        Player.setCurrentScore(40);
        Assert.assertEquals(40, Player.getCurrentScore());
    }

    @Test
    public void testIsOceanUnlocked() {
        Assert.assertFalse(Player.isOceanUnlocked());
    }

    @Test
    public void testUnlockOcean() {
        Player.unlockOcean();
        Assert.assertTrue(Player.isOceanUnlocked());
    }

    @Test
    public void testGetLastScene() {
        Assert.assertNull(Player.getLastScene());
    }

    @Test
    public void testSetLastScene() {
        Player.setLastScene("Controller.fxml");
        Assert.assertEquals("Controller.fxml", Player.getLastScene());
    }

    @Test
    public void testGetCatchThreshold() {
        Assert.assertEquals(120, Player.getCatchThreshold());
    }

    @Test
    public void testDecrementThreshold() {
        Player.decrementThreshold();
        Assert.assertEquals(115, Player.getCatchThreshold());
    }

    @Test
    public void testGetMaxBaitStrength() {
        Assert.assertEquals(150, Player.getMaxBaitStrength());
    }

    @Test
    public void testIncreaseBaitStrength() {
        Player.increaseBaitStrength();
        Assert.assertEquals(140, Player.getMaxBaitStrength());
    }
}

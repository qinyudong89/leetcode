package od.base;

import java.util.*;
import java.math.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class HJTest {

    @InjectMocks
    private HJ hj;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void lengthOfLastWord_WithMultipleWords_ReturnsLastWordLength() {
        int result = HJ.lengthOfLastWord("hello world test");
        Assert.assertEquals(4, result);
    }

    @Test
    public void lengthOfLastWord_WithSingleWord_ReturnsWordLength() {
        int result = HJ.lengthOfLastWord("hello");
        Assert.assertEquals(5, result);
    }

    @Test
    public void lengthOfLastWord_WithTrailingSpaces_ReturnsLastWordLength() {
        int result = HJ.lengthOfLastWord("hello world  ");
        Assert.assertEquals(5, result);
    }

    @Test
    public void lengthOfLastWord_WithEmptyString_ReturnsZero() {
        int result = HJ.lengthOfLastWord("");
        Assert.assertEquals(0, result);
    }

    @Test
    public void lengthOfLastWord_WithOnlySpaces_ReturnsZero() {
        int result = HJ.lengthOfLastWord("   ");
        Assert.assertEquals(0, result);
    }

    @Test
    public void lengthOfLastWord_WithSpecialCharacters_ReturnsLastWordLength() {
        int result = HJ.lengthOfLastWord("hello world!$#@");
        Assert.assertEquals(5, result);
    }
}

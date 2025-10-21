package org.t13.app.testbase;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class UnitTestBase {
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}

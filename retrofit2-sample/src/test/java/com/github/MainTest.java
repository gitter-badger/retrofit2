/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.json.JSONObject;
import org.json.JSONException;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.github.*;

import rx.Observable;
import rx.functions.*;
import java.util.Arrays;

public class MainTest {
    @Test
    public void testContributors() {
        GitHub github = GitHub.create();
        github.contributors("yongjhih", "retrofit2").forEach(new Action1<Contributor>() {
            @Override public void call(Contributor contributor) {
                System.out.println("retrofit2" + ":" + "contributor:" + contributor.login());
            }
        }, new Action1<Throwable>() {
            @Override public void call(Throwable e) {
                System.out.println("retrofit2" + ":" + "e:" + e);
                System.out.println("retrofit2" + ":" + "e.stack:" + Arrays.deepToString(e.getStackTrace()));
                throw new RuntimeException(e);
            }
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        assertTrue(true);
    }
}

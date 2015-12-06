/*******************************************************************************
 * Copyright 2013 Gabriele Mariotti
 *
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
 *******************************************************************************/
package com.amazon.mohsinha.ccxhack;

import android.app.Activity;
import android.view.GestureDetector;

import java.util.ArrayList;

public class ListHelper {

    protected static ArrayList<MyObj> buildData() {
        ArrayList<MyObj> list = new ArrayList<MyObj>();

        MyObj obj = new MyObj();
        obj.setName("Amazon");
        obj.setTitle("Hola");
        list.add(obj);

        return list;
    }

    // -----------------------------------------------------------------------------------------------------------


    public static ViewHolderAdapter buildViewHolderAdapter(MainActivity context,
                                                           int textViewResourceId, GestureDetector gdt) {

        ArrayList<MyObj> list = buildData();
        ViewHolderAdapter viewHolder = new ViewHolderAdapter(context, textViewResourceId, gdt);
        viewHolder.addAll(list);
        return viewHolder;
    }

    // -----------------------------------------------------------------------------------------------------------

}

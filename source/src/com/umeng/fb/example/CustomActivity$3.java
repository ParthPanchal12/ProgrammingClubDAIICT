// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.umeng.fb.model.Conversation;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class this._cls0
    implements android.view.ner
{

    final CustomActivity this$0;

    public void onClick(View view)
    {
        view = CustomActivity.access$5(CustomActivity.this).getText().toString();
        CustomActivity.access$5(CustomActivity.this).getEditableText().clear();
        if (!TextUtils.isEmpty(view))
        {
            CustomActivity.access$0(CustomActivity.this).addUserReply(view);
            CustomActivity.access$6(CustomActivity.this).notifyDataSetChanged();
            CustomActivity.access$7(CustomActivity.this);
            CustomActivity.access$8(CustomActivity.this);
        }
    }

    plyAdapter()
    {
        this$0 = CustomActivity.this;
        super();
    }
}

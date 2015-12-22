// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.allinone.free.dialog.CopyDialog;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import java.util.List;

// Referenced classes of package com.umeng.fb.example:
//            CustomActivity

class this._cls0 extends BaseAdapter
{
    class ViewHolder
    {

        TextView replyContent;
        TextView replyData;
        ProgressBar replyProgressBar;
        ImageView replyStateFailed;
        final CustomActivity.ReplyAdapter this$1;

        ViewHolder()
        {
            this$1 = CustomActivity.ReplyAdapter.this;
            super();
        }
    }


    final CustomActivity this$0;

    public int getCount()
    {
        return CustomActivity.access$0(CustomActivity.this).getReplyList().size();
    }

    public Object getItem(int i)
    {
        return CustomActivity.access$0(CustomActivity.this).getReplyList().get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return !"dev_reply".equals(((Reply)CustomActivity.access$0(CustomActivity.this).getReplyList().get(i)).type) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final Reply reply = (Reply)CustomActivity.access$0(CustomActivity.this).getReplyList().get(i);
        if (view == null)
        {
            if ("dev_reply".equals(reply.type))
            {
                view = LayoutInflater.from(CustomActivity.access$1(CustomActivity.this)).inflate(0x7f030034, null);
            } else
            {
                view = LayoutInflater.from(CustomActivity.access$1(CustomActivity.this)).inflate(0x7f030035, null);
            }
            viewgroup = new ViewHolder();
            viewgroup.replyContent = (TextView)view.findViewById(0x7f0600e3);
            viewgroup.replyProgressBar = (ProgressBar)view.findViewById(0x7f0600e2);
            viewgroup.replyStateFailed = (ImageView)view.findViewById(0x7f0600e1);
            viewgroup.replyData = (TextView)view.findViewById(0x7f0600e4);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).replyContent.setText(reply.content);
        if (!"dev_reply".equals(reply.type))
        {
            if ("not_sent".equals(reply.status))
            {
                ((ViewHolder) (viewgroup)).replyStateFailed.setVisibility(0);
            } else
            {
                ((ViewHolder) (viewgroup)).replyStateFailed.setVisibility(8);
            }
            if ("sending".equals(reply.status))
            {
                ((ViewHolder) (viewgroup)).replyProgressBar.setVisibility(0);
            } else
            {
                ((ViewHolder) (viewgroup)).replyProgressBar.setVisibility(8);
            }
        }
        ((ViewHolder) (viewgroup)).replyContent.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final CustomActivity.ReplyAdapter this$1;
            private final Reply val$reply;

            public boolean onLongClick(View view1)
            {
                view1 = new CopyDialog(this$0, 0x7f0c0064);
                view1.setCanceledOnTouchOutside(true);
                view1.show();
                LinearLayout linearlayout = (LinearLayout)view1.findViewById(0x7f0600dc);
                LinearLayout linearlayout1 = (LinearLayout)view1.findViewById(0x7f0600dd);
                linearlayout.setOnClickListener(view1. new android.view.View.OnClickListener() {

                    final _cls1 this$2;
                    private final CopyDialog val$dialog;
                    private final Reply val$reply;

                    public void onClick(View view)
                    {
                        copy(reply.content, CustomActivity.access$1(this$0));
                        dialog.dismiss();
                    }

            
            {
                this$2 = final__pcls1;
                reply = reply1;
                dialog = CopyDialog.this;
                super();
            }
                });
                linearlayout1.setOnClickListener(view1. new android.view.View.OnClickListener() {

                    final _cls1 this$2;
                    private final CopyDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$2 = final__pcls1;
                dialog = CopyDialog.this;
                super();
            }
                });
                return false;
            }


            
            {
                this$1 = CustomActivity.ReplyAdapter.this;
                reply = reply1;
                super();
            }
        });
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }


    _cls1.val.reply()
    {
        this$0 = CustomActivity.this;
        super();
    }
}

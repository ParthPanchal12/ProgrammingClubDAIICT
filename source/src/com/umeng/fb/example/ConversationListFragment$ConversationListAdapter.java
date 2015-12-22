// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.umeng.fb.example:
//            ConversationListFragment

class agent extends ArrayAdapter
{
    class ViewHolder
    {

        TextView text1;
        TextView text2;
        final ConversationListFragment.ConversationListAdapter this$1;

        ViewHolder()
        {
            this$1 = ConversationListFragment.ConversationListAdapter.this;
            super();
        }
    }


    private FeedbackAgent agent;
    private Context context;
    private List conversationList;
    LayoutInflater mInflater;
    final ConversationListFragment this$0;

    public void addConversation(Conversation conversation)
    {
        conversationList.add(conversation);
        notifyDataSetChanged();
    }

    public String getConversationId(int i)
    {
        return ((Conversation)conversationList.get(i)).getId();
    }

    public int getCount()
    {
        if (conversationList == null)
        {
            return 0;
        } else
        {
            return conversationList.size();
        }
    }

    public Object getItem(int i)
    {
        if (conversationList == null)
        {
            return null;
        } else
        {
            return (Conversation)conversationList.get(i);
        }
    }

    public long getItemId(int i)
    {
        return super.getItemId(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Conversation conversation;
        if (view == null)
        {
            view = mInflater.inflate(0x1090017, null);
            viewgroup = new ViewHolder();
            viewgroup.text1 = (TextView)view.findViewById(0x1020014);
            viewgroup.text2 = (TextView)view.findViewById(0x1020015);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        conversation = (Conversation)conversationList.get(i);
        if (conversation.getReplyList().size() > 0)
        {
            long l = ((Reply)conversation.getReplyList().get(conversation.getReplyList().size() - 1)).created_at;
            String s = (new SimpleDateFormat("yy/MM/dd HH:mm:ss")).format(new Date(l));
            ((ViewHolder) (viewgroup)).text1.setText(((Reply)conversation.getReplyList().get(0)).content);
            ((ViewHolder) (viewgroup)).text2.setText((new StringBuilder("last replied: ")).append(s).toString());
        }
        return view;
    }

    public ViewHolder.this._cls1(Context context1)
    {
        this$0 = ConversationListFragment.this;
        super(context1, 0x1090017);
        context = context1;
        conversationList = new ArrayList();
        agent = new FeedbackAgent(context1);
        conversationlistfragment = agent.getAllConversationIds().iterator();
        do
        {
            if (!hasNext())
            {
                mInflater = LayoutInflater.from(context1);
                return;
            }
            String s = (String)next();
            conversationList.add(agent.getConversationById(s));
        } while (true);
    }
}

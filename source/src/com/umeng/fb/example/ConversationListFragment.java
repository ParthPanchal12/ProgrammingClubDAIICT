// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ConversationListFragment extends ListFragment
{
    public static interface Callbacks
    {

        public abstract void onItemSelected(String s);
    }

    class ConversationListAdapter extends ArrayAdapter
    {

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

        public ConversationListAdapter(Context context1)
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

    class ConversationListAdapter.ViewHolder
    {

        TextView text1;
        TextView text2;
        final ConversationListAdapter this$1;

        ConversationListAdapter.ViewHolder()
        {
            this$1 = ConversationListAdapter.this;
            super();
        }
    }


    private static final String STATE_ACTIVATED_POSITION = "activated_position";
    private static final String TAG = com/umeng/fb/example/ConversationListFragment.getName();
    private static Callbacks sDummyCallbacks = new Callbacks() {

        public void onItemSelected(String s)
        {
        }

    };
    private int mActivatedPosition;
    private Callbacks mCallbacks;
    private ConversationListAdapter mConversationListAdapter;

    public ConversationListFragment()
    {
        mCallbacks = sDummyCallbacks;
        mActivatedPosition = -1;
    }

    private void setActivatedPosition(int i)
    {
        getListView().setItemChecked(i, true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks))
        {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        } else
        {
            mCallbacks = (Callbacks)activity;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mConversationListAdapter = new ConversationListAdapter(getActivity());
        setListAdapter(mConversationListAdapter);
        setHasOptionsMenu(true);
    }

    public void onDetach()
    {
        super.onDetach();
        mCallbacks = sDummyCallbacks;
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        mCallbacks.onItemSelected(mConversationListAdapter.getConversationId(i));
    }

    public void onResume()
    {
        super.onResume();
        mConversationListAdapter.notifyDataSetChanged();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mActivatedPosition != -1)
        {
            bundle.putInt("activated_position", mActivatedPosition);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mActivatedPosition = 0;
        if (bundle != null && bundle.containsKey("activated_position"))
        {
            mActivatedPosition = bundle.getInt("activated_position");
            setActivatedPosition(mActivatedPosition);
        }
    }

    public void setActivateOnItemClick(boolean flag)
    {
        ListView listview = getListView();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        listview.setChoiceMode(i);
    }

}

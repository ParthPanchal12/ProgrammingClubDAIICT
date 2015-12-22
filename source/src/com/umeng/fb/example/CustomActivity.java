// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.fb.example;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.allinone.free.activity.MyMainActivity;
import com.allinone.free.dialog.CopyDialog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.SyncListener;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.UserInfo;
import com.umeng.message.PushAgent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomActivity extends Activity
{
    class ReplyAdapter extends BaseAdapter
    {

        final CustomActivity this$0;

        public int getCount()
        {
            return mComversation.getReplyList().size();
        }

        public Object getItem(int i)
        {
            return mComversation.getReplyList().get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public int getItemViewType(int i)
        {
            return !"dev_reply".equals(((Reply)mComversation.getReplyList().get(i)).type) ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Reply reply = (Reply)mComversation.getReplyList().get(i);
            if (view == null)
            {
                if ("dev_reply".equals(reply.type))
                {
                    view = LayoutInflater.from(mContext).inflate(0x7f030034, null);
                } else
                {
                    view = LayoutInflater.from(mContext).inflate(0x7f030035, null);
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
            ((ViewHolder) (viewgroup)).replyContent.setOnLongClickListener(reply. new android.view.View.OnLongClickListener() {

                final ReplyAdapter this$1;
                private final Reply val$reply;

                public boolean onLongClick(View view)
                {
                    view = new CopyDialog(_fld0, 0x7f0c0064);
                    view.setCanceledOnTouchOutside(true);
                    view.show();
                    LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0600dc);
                    LinearLayout linearlayout1 = (LinearLayout)view.findViewById(0x7f0600dd);
                    linearlayout.setOnClickListener(view. new android.view.View.OnClickListener() {

                        final ReplyAdapter._cls1 this$2;
                        private final CopyDialog val$dialog;
                        private final Reply val$reply;

                        public void onClick(View view)
                        {
                            copy(reply.content, mContext);
                            dialog.dismiss();
                        }

            
            {
                this$2 = final__pcls1;
                reply = reply1;
                dialog = CopyDialog.this;
                super();
            }
                    });
                    linearlayout1.setOnClickListener(view. new android.view.View.OnClickListener() {

                        final ReplyAdapter._cls1 this$2;
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
                this$1 = final_replyadapter;
                reply = Reply.this;
                super();
            }
            });
            return view;
        }

        public int getViewTypeCount()
        {
            return 2;
        }


        ReplyAdapter()
        {
            this$0 = CustomActivity.this;
            super();
        }
    }

    class ReplyAdapter.ViewHolder
    {

        TextView replyContent;
        TextView replyData;
        ProgressBar replyProgressBar;
        ImageView replyStateFailed;
        final ReplyAdapter this$1;

        ReplyAdapter.ViewHolder()
        {
            this$1 = ReplyAdapter.this;
            super();
        }
    }


    private static Typeface typeFace = null;
    private final String TAG = com/umeng/fb/example/CustomActivity.getName();
    private final int VIEW_TYPE_COUNT = 2;
    private final int VIEW_TYPE_DEV = 1;
    private final int VIEW_TYPE_USER = 0;
    private ReplyAdapter adapter;
    private ImageView appfan;
    private TextView feedbacktv;
    private EditText inputEdit;
    private String jpushfan;
    private FeedbackAgent mAgent;
    private Conversation mComversation;
    private Context mContext;
    private ListView mListView;
    private PushAgent mPushAgent;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Button sendBtn;

    public CustomActivity()
    {
        jpushfan = "";
    }

    private void initView()
    {
        appfan = (ImageView)findViewById(0x7f06004f);
        feedbacktv = (TextView)findViewById(0x7f060050);
        typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
        feedbacktv.setTypeface(typeFace);
        appfan.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomActivity this$0;

            public void onClick(View view)
            {
                jpushfan = getIntent().getStringExtra("jpush");
                if (TextUtils.isEmpty(jpushfan))
                {
                    finish();
                    return;
                } else
                {
                    startActivity(new Intent(CustomActivity.this, com/allinone/free/activity/MyMainActivity));
                    finish();
                    return;
                }
            }

            
            {
                this$0 = CustomActivity.this;
                super();
            }
        });
        mListView = (ListView)findViewById(0x7f060055);
        sendBtn = (Button)findViewById(0x7f060052);
        inputEdit = (EditText)findViewById(0x7f060053);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(0x7f060054);
        sendBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomActivity this$0;

            public void onClick(View view)
            {
                view = inputEdit.getText().toString();
                inputEdit.getEditableText().clear();
                if (!TextUtils.isEmpty(view))
                {
                    mComversation.addUserReply(view);
                    adapter.notifyDataSetChanged();
                    scrollToBottom();
                    sync();
                }
            }

            
            {
                this$0 = CustomActivity.this;
                super();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final CustomActivity this$0;

            public void onRefresh()
            {
                sync();
            }

            
            {
                this$0 = CustomActivity.this;
                super();
            }
        });
    }

    private void scrollToBottom()
    {
        if (adapter.getCount() > 0)
        {
            mListView.smoothScrollToPosition(adapter.getCount());
        }
    }

    private void sync()
    {
        mComversation.sync(new SyncListener() {

            final CustomActivity this$0;

            public void onReceiveDevReply(List list)
            {
                mSwipeRefreshLayout.setRefreshing(false);
                adapter.notifyDataSetChanged();
                scrollToBottom();
            }

            public void onSendUserReply(List list)
            {
            }

            
            {
                this$0 = CustomActivity.this;
                super();
            }
        });
    }

    public void copy(String s, Context context)
    {
        ((ClipboardManager)context.getSystemService("clipboard")).setText(s);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030016);
        JPushInterface.init(this);
        mContext = this;
        initView();
        bundle = View.inflate(this, 0x7f030084, null);
        mListView.addHeaderView(bundle, null, false);
        mAgent = new FeedbackAgent(this);
        mComversation = (new FeedbackAgent(this)).getDefaultConversation();
        adapter = new ReplyAdapter();
        mListView.setAdapter(adapter);
        sync();
        mPushAgent = PushAgent.getInstance(this);
        (new Thread(new Runnable() {

            final CustomActivity this$0;

            public void run()
            {
                UserInfo userinfo;
                Object obj;
                try
                {
                    Thread.sleep(2000L);
                    obj = mAgent.getUserInfo();
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                    return;
                }
                userinfo = ((UserInfo) (obj));
                if (obj != null)
                {
                    break MISSING_BLOCK_LABEL_31;
                }
                userinfo = new UserInfo();
                userinfo.getContact();
                obj = new HashMap();
                ((Map) (obj)).put("user_id", JPushInterface.getRegistrationID(CustomActivity.this));
                userinfo.setContact(((Map) (obj)));
                mAgent.setUserInfo(userinfo);
                mAgent.updateUserInfo();
                return;
            }

            
            {
                this$0 = CustomActivity.this;
                super();
            }
        })).start();
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
        JPushInterface.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        JPushInterface.onResume(this);
    }











}

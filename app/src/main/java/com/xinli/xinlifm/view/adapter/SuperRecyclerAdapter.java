package com.xinli.xinlifm.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.xinli.xinlifm.R;

import java.util.Collection;
import java.util.List;

/**
 *  这个封装也并不好
 *  所以，可以自己写，我就简单的封装了一下
 *  直接调用就好了，
 *
 *  addAll
 *  clear
 *  getItemCount()----> 我们就不用写了
 *  多了个点击事件，如果有问题，建议直接重新写，考虑并没有那么全面
 *
 *
 *
 * Created by zz on 16-10-12.
 */

public abstract class SuperRecyclerAdapter<D,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public Context context;
    public List<D> list;
    public int[] layoutId;
    public OnChildClickListener onChildClickListener;

    public SuperRecyclerAdapter(Context context, List<D> list, int[] layoutId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
    }

    public void addAll(Collection collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    /**
     *  子类的布局文件
     *  加了以下载的布局
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return R.layout.download;
        } else {
            return getToChild(position);
        }
    }
    public void setOnChildItemClickListener(OnChildClickListener onChildClickListener){
        this.onChildClickListener = onChildClickListener;
    }
    public abstract int getToChild(int position);

    public interface  OnChildClickListener {
        /**
         *
         * @param obj  item的值
         * @param url  图片地址
         * @param position 对应位置
         */
        void onChildItemClickListener(Object obj,String url,int position);
    }

    /**
     *  通过这个方法得到position item的值
     * @param position
     * @return
     */
    public D getData(int position){
        return list.get(position);
    }

}

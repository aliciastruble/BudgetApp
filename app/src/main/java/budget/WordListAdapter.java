package budget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.room.aya.roomwordsample2.R;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Transaction> mTransactions; // Cached copy of words

    WordListAdapter(Context context){ mInflater = LayoutInflater.from(context);}

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mTransactions != null){
            Transaction current = mTransactions.get(position);
            holder.wordItemView.setText(current.getId());
        } else {
            holder.wordItemView.setText("No word");
        }
    }

    void setWords(List<Transaction> transactions){
        mTransactions = transactions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mTransactions != null){
            return mTransactions.size();
        } else {
            return 0;
        }
    }


}

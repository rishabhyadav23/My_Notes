package com.example.mynotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.databinding.NotesViewBinding;

public class RViewAdapter extends ListAdapter<Note, RViewAdapter.ViewHolder> {
   public  RViewAdapter(){
       super(CALLBACK);
   }
   public static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
       @Override
       public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
           return oldItem.getId()==newItem.getId();
       }

       @Override
       public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
           return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getDescription().equals(newItem.getDescription());
       }
   };
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_view,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = getItem(position);
        holder.binding.titleView.setText(note.getTitle());
        holder.binding.contentView.setText(note.getDescription());
    }
    public Note getNote(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        NotesViewBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = NotesViewBinding.bind(itemView);
        }
    }
}

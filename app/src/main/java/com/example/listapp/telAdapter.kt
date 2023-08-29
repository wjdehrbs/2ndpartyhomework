import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.MultiData
import com.example.listapp.databinding.ItemContactBinding
import com.example.listapp.databinding.ItemFavoriteBinding

class telAdapter(private val itemList: List<MultiData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_FAVORITE = 1
        const val VIEW_TYPE_CONTACT = 2
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList[position].type == MultiData.TYPE_FAVORITE) {
            VIEW_TYPE_FAVORITE
        } else {
            VIEW_TYPE_CONTACT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_TYPE_FAVORITE) {
            val binding = ItemFavoriteBinding.inflate(inflater, parent, false)
            FavoriteHolder(binding)
        } else {
            val binding = ItemContactBinding.inflate(inflater, parent, false)
            ContactHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        if (holder is FavoriteHolder) {
            holder.bind(item)
        } else if (holder is ContactHolder) {
            holder.bind(item)
        }
    }

    inner class FavoriteHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiData) {
            binding.fvIcon.setImageResource(item.aIcon)
            binding.fvUserid.text = item.aName
            binding.fvTxtUsername.text = item.aTel
        }
    }

    inner class ContactHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiData) {
            binding.imgUserIcon.setImageResource(item.aIcon)
            binding.txtUserId.text = item.aName
            binding.txtUserName.text = item.aTel
        }
    }
}
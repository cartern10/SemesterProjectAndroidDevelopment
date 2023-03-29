import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semesterproject.R
import com.example.semesterproject.databinding.FragmentTraderListBinding
import com.example.semesterproject.ui.TraderDetailFragment
import com.example.semesterproject.ui.adapter.TraderAdapter
import com.example.semesterproject.viewmodel.TraderViewModel


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TraderListFragment : Fragment() {

    private var _binding: FragmentTraderListBinding? = null
    private val binding get() = _binding!!

    private val characterViewModel: TraderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTraderListBinding.inflate(inflater, container, false)

        binding.traderRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = characterViewModel.fillData()

        val adapter = TraderAdapter(characters) { position ->
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container_view,
                    TraderDetailFragment.newInstance(characters[position].id),
                )
                addToBackStack(null)
            }
        }
        binding.traderRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
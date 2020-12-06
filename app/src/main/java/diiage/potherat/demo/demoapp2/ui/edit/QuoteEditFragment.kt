package diiage.potherat.demo.demoapp2.ui.edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import diiage.potherat.demo.demoapp2.R
import diiage.potherat.demo.demoapp2.databinding.FragmentQuoteEditBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class QuoteEditFragment : Fragment() {

    companion object {
        fun newInstance() = QuoteEditFragment()
    }

    private val viewModel: QuoteEditViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = FragmentQuoteEditBinding.inflate(inflater, container, false)

        v.btnValid.setOnClickListener {

            viewModel.create()
        }
        v.viewmodel = viewModel

        return v.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.actionReceiver.observe(viewLifecycleOwner, Observer {
            if (it) findNavController().navigate(R.id.action_nav_quote_edit_pop2)
        })

    }

}
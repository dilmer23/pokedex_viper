package com.example.poke_api_app_viper.view

import PokemonColorUtil
import PokemonDetailEntity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.contract.PokemonDetailContract
import com.example.poke_api_app_viper.databinding.FragmentPokemonBinding
import com.example.poke_api_app_viper.databinding.FragmentPokemonDetailBinding
import com.example.poke_api_app_viper.presenter.PokemonDetailPresenter
import com.example.poke_api_app_viper.utils.GlobalVars
import com.example.poke_api_app_viper.utils.dismissCustomDialog
import com.example.poke_api_app_viper.utils.showCustomDialog
import com.example.poke_api_app_viper.view.common.CustomDialog


class PokemonDetailFragment : Fragment() , PokemonDetailContract.View {
    private lateinit var presenter: PokemonDetailContract.Presenter
    private lateinit var router: PokemonContract.Router
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!
    private var customDialog: CustomDialog? = null


    companion object {
        private const val ARG_URL = "url"

        fun newInstance(url: String): PokemonDetailFragment {
            val fragment = PokemonDetailFragment()
            val args = Bundle()
            args.putString(ARG_URL, url)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(ARG_URL)
        presenter = PokemonDetailPresenter(this)
        if (url != null) {
            presenter.getPokemonDetail(url)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showPokemonDetail(data: PokemonDetailEntity) {
        binding.toolbar.title = data.name
        binding.txtName.text = data.name
        binding.txtHeigth.text = data.height.toString()
        binding.txtWeight.text = data.weight.toString()
        binding.txtBaseExperience.text = data.baseExperience.toString()
        binding.textViewID.text = "#" + data.id.toString()
        var color = PokemonColorUtil(requireContext()).getPokemonColor(data.types)
        binding.relativeLayoutBackground.setBackgroundColor(color)
        binding.toolbar.setBackgroundColor(color)

        data.types?.forEachIndexed { index, type ->
            when (index) {
                0 -> binding.textViewType1.text = type.type?.name ?: ""
                1 -> binding.textViewType2.text = type.type?.name ?: ""
                2 -> binding.textViewType3.text = type.type?.name ?: ""
            }
        }
            Glide.with(this)
                .load(GlobalVars.imgPomemonDetail+data.id+".png")
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(binding.imageViewPokemon)
    }

    override fun showErrorDetail(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    }

    override fun showAlerDialog(message: String) {
        customDialog = CustomDialog(requireContext(), message)
    }

    override fun dismisAlerDialog() {
        customDialog?.dismiss()
    }


}
package com.example.poke_api_app_viper.view

import PokemonColorUtil
import PokemonDetailEntity
import PokemonFragment
import PokemonTipoImg
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.poke_api_app_viper.R
import com.example.poke_api_app_viper.contract.PokemonDetailContract
import com.example.poke_api_app_viper.databinding.FragmentPokemonDetailBinding
import com.example.poke_api_app_viper.presenter.PokemonDetailPresenter
import com.example.poke_api_app_viper.utils.GlobalVars
import com.example.poke_api_app_viper.view.adapter.PokemonAbilitiesAdapter
import com.example.poke_api_app_viper.view.adapter.ViewPagerAdapter
import com.example.poke_api_app_viper.view.common.CustomDialog
import com.example.poke_api_app_viper.view.common.PokemonAbilitiesFragment
import com.example.poke_api_app_viper.view.common.PokemonMovesFragment
import com.example.poke_api_app_viper.view.common.PokemonStatsFragment
import com.google.gson.Gson


class PokemonDetailFragment : Fragment() , PokemonDetailContract.View {
    private lateinit var presenter: PokemonDetailContract.Presenter
    private lateinit var route: PokemonContract.Router
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!
    private var customDialog: CustomDialog? = null
    private lateinit var adapter: PokemonAbilitiesAdapter


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
        binding.txtHeigth.text = "Height :" + " "+ data.height.toString()
        binding.txtWeight.text = "weight :" + " "  +data.weight.toString()
        binding.textViewID.text = "#" +  " " + data.id.toString()
        var color = PokemonColorUtil(requireContext()).getPokemonColor(data.types)
        binding.tabLayout.setBackgroundColor(color)
        binding.relativeLayoutBackground.setBackgroundColor(color)
        binding.toolbar.setBackgroundColor(color)
        binding.toolbar.setOnClickListener{
            val fragment = PokemonFragment()
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

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
        binding.imagenPomemonType.setImageDrawable(PokemonTipoImg(requireContext()).getPokemonColor(
            data.types!!
        ))


        // Configura el ViewPager con el adaptador y los fragmentos.
        val gson = Gson()
        val dataAbilitis = gson.toJson(data.abilities)
        val dataStats = gson.toJson(data.stats)
        val dataMove = gson.toJson(data.moves)
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(PokemonAbilitiesFragment.newInstance(dataAbilitis,color), "abilities")
        viewPagerAdapter.addFragment(PokemonStatsFragment.newInstance(dataStats,color), "stat")
        viewPagerAdapter.addFragment(PokemonMovesFragment.newInstance(dataMove,color), "move")
        viewPagerAdapter.addFragment(PokemonStatsFragment.newInstance(dataStats,color), "evo")
        binding.viewPager.adapter = viewPagerAdapter

        // Vincula el TabLayout con el ViewPager.
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.setBackgroundColor(color)

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
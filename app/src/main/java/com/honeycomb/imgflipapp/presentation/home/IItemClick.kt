package com.honeycomb.imgflipapp.presentation.home

import com.honeycomb.imgflipapp.domain.memes.Memes

interface IItemClick {
    fun itemClicked(memes: Memes)
}
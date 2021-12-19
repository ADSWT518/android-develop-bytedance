package me.adswt518.todolist.beans

enum class State(val intValue: Int) {
    TODO(0), DONE(1);

    companion object {
        fun from(intValue: Int): State {
            for (state in me.adswt518.todolist.beans.State.values()) {
                if (state.intValue == intValue) {
                    return state
                }
            }
            return TODO // default
        }
    }
}

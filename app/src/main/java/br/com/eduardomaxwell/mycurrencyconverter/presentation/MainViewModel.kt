
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue
import br.com.eduardomaxwell.mycurrencyconverter.domain.GetExchangeValueUseCase
import br.com.eduardomaxwell.mycurrencyconverter.domain.SaveExchangeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    private val getExchangeValueUseCase: GetExchangeValueUseCase,
    private val saveExchangeUseCase: SaveExchangeUseCase
) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun getExchangeValue(coins: String) = viewModelScope.launch {
        getExchangeValueUseCase(coins)
            .flowOn(Dispatchers.Main)
            .onStart {
//               to show progress bar
                _state.value = State.Loading
            }
            .catch {
//                show error
                _state.value = State.Error(it)
            }
            .collect {
//                success
                _state.value = State.Success(it)
            }
    }

    fun saveExchange(exchange: ExchangeResponseValue) = viewModelScope.launch {
        saveExchangeUseCase(exchange)
            .flowOn(Dispatchers.Main)
            .onStart {
//               to show progress bar
                _state.value = State.Loading
            }
            .catch {
//                show error
                _state.value = State.Error(it)
            }
            .collect {
//                success
                _state.value = State.Saved
            }
    }

    sealed class State {
        object Loading : State()
        object Saved: State()

        data class Success(val exchange: ExchangeResponseValue) : State()
        data class Error(val error: Throwable) : State()
    }
}
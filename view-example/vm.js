function createViewModel(initialState = {}) {
  const state = { ...initialState };
  const subscribers = {};

  function subscribe(prop, callback) {
    if (!subscribers[prop]) {
      subscribers[prop] = [];
    }
    subscribers[prop].push(callback);
  }

  function publish(prop, value) {
    if (subscribers[prop]) {
      subscribers[prop].forEach((cb) => cb(value));
    }
  }

  function set(prop, value) {
    if (state[prop] === value) return;
    state[prop] = value;
    publish(prop, value);
  }

  function get(prop) {
    return state[prop];
  }

  return {
    get,
    set,
    subscribe,
  };
}

package ru.netology.repository;

import ru.netology.model.Post;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


// Stub
public class PostRepository {

  private long counter = 0;
  private ConcurrentHashMap <Long, Post> collection;

  public ConcurrentHashMap <Long, Post> all() {
    return this.collection;
  }

  public Optional<Post> getById(long id) {
    if (collection.containsKey(id)) {
      return Optional.of(collection.get(id));
    } else {
      return Optional.empty();
    }
  }

  public synchronized Post save(Post post) {
      if (post.getId() == 0) {
        counter++;
        collection.put(counter, post);
      } else if (collection.containsKey(post.getId())) {
        collection.put(post.getId(), post);
      }
    return collection.get(post.getId());
  }

  public void removeById(long id) {
    collection.remove(id);
  }
}
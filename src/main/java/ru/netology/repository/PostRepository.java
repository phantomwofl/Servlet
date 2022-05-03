package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


// Stub
public class PostRepository {

  private AtomicLong counter = new AtomicLong(0L);
  private ConcurrentHashMap <Long, Post> collection = new ConcurrentHashMap<>();

  public List<Post> all() {
    return new ArrayList<>(this.collection.values());
  }

  public Optional<Post> getById(long id) {
    if (collection.containsKey(id)) {
      return Optional.of(collection.get(id));
    } else {
      return Optional.empty();
    }
  }

  public Post save(Post post) {
      if (post.getId() == 0) {
        Long id = counter.incrementAndGet();
        post.setId(id-1);
        collection.put(post.getId(), post);
      } else {
        collection.put(post.getId(), post);
      }
    return post;
  }

  public void removeById(long id) {
    collection.remove(id);
  }
}
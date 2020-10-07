// Generated code from Butter Knife. Do not modify!
package app.android.com.gitrepostriesApp.view.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TopGitRepositories$$ViewBinder<T extends TopGitRepositories> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131230930, "field 'mProgressbar'");
    target.mProgressbar = finder.castView(view, 2131230930, "field 'mProgressbar'");
    view = finder.findRequiredView(source, 2131230905, "field 'my_recycler_view'");
    target.my_recycler_view = finder.castView(view, 2131230905, "field 'my_recycler_view'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends TopGitRepositories> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.mProgressbar = null;
      target.my_recycler_view = null;
    }
  }
}

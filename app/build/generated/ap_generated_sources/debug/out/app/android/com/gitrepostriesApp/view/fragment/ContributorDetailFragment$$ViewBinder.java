// Generated code from Butter Knife. Do not modify!
package app.android.com.gitrepostriesApp.view.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ContributorDetailFragment$$ViewBinder<T extends ContributorDetailFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131230929, "field 'mProgressbar'");
    target.mProgressbar = finder.castView(view, 2131230929, "field 'mProgressbar'");
    view = finder.findRequiredView(source, 2131230935, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131230935, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131230881, "field 'mContributorImage'");
    target.mContributorImage = finder.castView(view, 2131230881, "field 'mContributorImage'");
    view = finder.findRequiredView(source, 2131231027, "field 'mName'");
    target.mName = finder.castView(view, 2131231027, "field 'mName'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ContributorDetailFragment> implements Unbinder {
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
      target.mRecyclerView = null;
      target.mContributorImage = null;
      target.mName = null;
    }
  }
}
